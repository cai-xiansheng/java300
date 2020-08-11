package sorm.com.zh.core;

import sorm.com.zh.bean.ColumnInfo;
import sorm.com.zh.bean.TableInfo;
import sorm.com.zh.po.Emp;
import sorm.com.zh.utils.JDBCUtils;
import sorm.com.zh.utils.ReflectUtils;
import sorm.com.zh.vo.EmpVO;

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
public class MySQLQuery extends Query {

    public static void testDML() {
        Emp emp = new Emp();
        emp.setEmpname("TOM");
        emp.setBirthDay(new java.sql.Date(System.currentTimeMillis()));
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
        List<EmpVO> list2 = new MySQLQuery().queryRows(sql2, EmpVO.class, null);
        for (EmpVO emp : list2) {
            System.out.println(emp.getEmpname() + "----" + emp.getAge() + "---" + emp.getSalary());
        }
    }

    public static void main(String[] args) {
        //Number number = (Number) new MySQLQuery().queryValue("select count(*) from emp where salary > ?", new Object[]{1000});
        Object object = new MySQLQuery().queryValue("select count(*) from emp where salary > ?", new Object[]{1000});
        //System.out.println((Number)object);
        System.out.println(object);
        //testQueryRows();
    }

    @Override
    public Object queryPagenate(int pageNum, int size) {
        return null;
    }
}
