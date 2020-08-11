package sorm2.sorm.com.zh.core;

import sorm2.sorm.com.zh.bean.ColumnInfo;
import sorm2.sorm.com.zh.bean.TableInfo;
import sorm2.sorm.com.zh.po.Emp;
import sorm2.sorm.com.zh.utils.JDBCUtils;
import sorm2.sorm.com.zh.utils.ReflectUtils;
import sorm2.sorm.com.zh.vo.EmpVO;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cai-xiansheng
 * @Description 负责针对MySQL数据库的查询
 * @create 2020-08-10 21:38
 */
@SuppressWarnings("all")
public class MySQLQuery implements Query {

    public static void testDML() {
        Emp emp = new Emp();
        emp.setEmpname("TOM");
        emp.setBirthDay(new Date(System.currentTimeMillis()));
        emp.setAge(20);
        emp.setSalary(300.9);
        emp.setId(5);
        //new MySQLQuery().delete(emp);
        //new MySQLQuery().insert(emp);
        new MySQLQuery().update(emp, new String[]{"empname", "age", "salary"});
    }

    public static void testQueryRows() {
        List<Emp> list = new MySQLQuery().queryRows("select id,empname,age,salary from emp where age>? and salary<?",
                Emp.class, new Object[]{2, 30000});
        for (Emp emp : list) {
            System.out.println(emp.getEmpname() + "----" + emp.getAge() + "---" + emp.getSalary());
        }

        String sql2 = "select e.id,e.empname,e.salary + e.bonus salary,age,d.dname deptName,d.address deptAddr " +
                "from emp e join dept d on e.deptId = d.id;";
        List<EmpVO> list2 = new MySQLQuery().queryRows(sql2,
                EmpVO.class, null);
        for (EmpVO emp : list2) {
            System.out.println(emp.getEmpname() + "----" + emp.getAge() + "---" + emp.getSalary());
        }
    }

    public static void main(String[] args) {
        Number number = (Number)new MySQLQuery().queryValue("select count(*) from emp where salary > ?", new Object[]{1000});
        Object object = new MySQLQuery().queryValue("select count(*) from emp where salary > ?", new Object[]{1000});
        //System.out.println((Number)object);
        System.out.println(object);
    }

    @Override
    public int executeDML(String sql, Object[] params) {
        Connection connection = DBManager.getConnection();
        int count = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            // 给sql设参
            JDBCUtils.handleParams(preparedStatement, params);
            System.out.println(preparedStatement);
            count = preparedStatement.executeUpdate();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            DBManager.close(preparedStatement, connection);
        }
        return count;
    }

    @Override
    public void insert(Object object) {
        // 把对象存到表中，insert into 表名(id,uname,pwd) values(?,?,?)
        Class clazz = object.getClass();
        List<Object> params = new ArrayList<>(); // 存储sql的参数对象
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sql = new StringBuilder("insert into " + tableInfo.gettName() + "(");
        int countNotNullField = 0; // 计算不为null的属性值
        for (Field field : fields) {
            String fieldName = field.getName();
            Object fieldValue = ReflectUtils.invokeGet(fieldName, object);

            if (fieldValue != null) {
                countNotNullField++;
                sql.append(fieldName + ",");
                params.add(fieldValue);
            }
        }
        sql.setCharAt(sql.length() - 1, ')');
        sql.append(" values(");
        for (int i = 0; i < countNotNullField; i++) {
            sql.append("?,");
        }
        sql.setCharAt(sql.length() - 1, ')');

        executeDML(sql.toString(), params.toArray());
    }

    @Override
    public void delete(Class clazz, Object id) {
        // Emp.class,2-->delete from emp where id = 2;

        // 通过Class对象找找TableInfo
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);

        // 获得主键
        ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
        String sql = "delete from " + tableInfo.gettName() + " where " + onlyPriKey.getName() + "=? ";

        executeDML(sql, new Object[]{id});

    }

    @Override
    public void delete(Object object) {
        Class clazz = object.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
        ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey(); // 主键

        // 通过反射机制，调用属性对应的get方法或set方法

        Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), object);
        delete(clazz, priKeyValue);
    }

    @Override
    public int update(Object object, String[] fieldNames) {
        // object{"uname","pwd"} --> update 表名 set uname = ?, pwd =? where id = ?;
        Class clazz = object.getClass();
        List<Object> params = new ArrayList<>();
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
        StringBuilder sql = new StringBuilder("update " + tableInfo.gettName() + " set ");
        for (String fName : fieldNames) {
            Object fValue = ReflectUtils.invokeGet(fName, object);
            params.add(fValue);
            sql.append(fName + "=?,");
        }
        sql.setCharAt(sql.length() - 1, ' ');
        sql.append("where " + tableInfo.getOnlyPriKey().getName() + "=? ");
        params.add(ReflectUtils.invokeGet(tableInfo.getOnlyPriKey().getName(), object)); // 增加主键的值
        return executeDML(sql.toString(), params.toArray());
    }

    @Override
    public List queryRows(String sql, Class clazz, Object[] params) {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        List list = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            // 给sql设参
            JDBCUtils.handleParams(preparedStatement, params);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 多行
            while (resultSet.next()) {
                if (list == null) {
                    list = new ArrayList();
                }
                Object rowObject = clazz.getDeclaredConstructor().newInstance(); // 调用javabean的无参构造器
                // 在Java9之后反射中的newInstance()被弃用，所以我们使用clazz.getDeclaredConstructor().newInstance();
                // 多列 select username,pwd,age from user where id > ? and age > 18
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(i + 1);

                    // 调用rowObj对象的setUsername方法，将columnValue的值设置进去
                    ReflectUtils.invokeSet(rowObject, columnName, columnValue);
                }
                list.add(rowObject);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
        List list = queryRows(sql, clazz, params);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    @Override
    public Object queryValue(String sql, Object[] params) {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object value = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            // 给sql设参
            JDBCUtils.handleParams(preparedStatement, params);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 多行
            while (resultSet.next()) {
                // select count(*) from user
                value = resultSet.getObject(1);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return value;
    }

    @Override
    public Number queryNumber(String sql, Object[] params) {
        return (Number) queryValue(sql, params);
    }
}
