package sorm.com.zh.core;

import sorm.com.zh.bean.ColumnInfo;
import sorm.com.zh.bean.TableInfo;
import sorm.com.zh.po.Emp;
import sorm.com.zh.utils.JDBCUtils;
import sorm.com.zh.utils.ReflectUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cai-xiansheng
 * @Description 负责针对MySQL数据库的查询
 * @create 2020-08-10 21:38
 */
public class MySQLQuery implements Query {

    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.setEmpname("TOM");
        emp.setBirthDay(new java.sql.Date(System.currentTimeMillis()));
        emp.setAge(20);
        emp.setSalary(300.9);
        emp.setId(5);
        //new MySQLQuery().delete(emp);
        //new MySQLQuery().insert(emp);
        new MySQLQuery().update(emp, new String[]{"empname","age","salary"});
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
        return null;
    }

    @Override
    public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
        return null;
    }

    @Override
    public Object queryValue(String sql, Object[] params) {
        return null;
    }

    @Override
    public Number queryNumber(String sql, Object[] params) {
        return null;
    }
}
