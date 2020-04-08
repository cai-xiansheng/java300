package mypro09.cn.zh.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张辉
 * @Description 测试Map的常用方法
 * @create 2020-04-08 16:55
 */
public class TestMap2 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1001,"zh",31000);
        Employee e2 = new Employee(1002,"zs",32000);
        Employee e3 = new Employee(1003,"zd",33000);
        Employee e4 = new Employee(1001,"zw",34000);

        Map<Integer,Employee> map = new HashMap<>();

        map.put(1001,e1);
        map.put(1002,e2);
        map.put(1003,e3);
        map.put(1004,e4);

        Employee emp = map.get(1001);
        System.out.println(emp.getSalary());

        System.out.println(map);

    }
}


class Employee {
    /** 雇员信息 */
    private int id;
    private String ename;
    private double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(int id, String ename, double salary) {
        this.id = id;
        this.ename = ename;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}