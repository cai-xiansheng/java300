package testJDBC.testORM;

import java.sql.Date;

/**
 * @author 张辉
 * @Description
 * @create 2020-08-07 17:20
 */
public class Emp { // 表结构和类对应
    private Integer id;
    private String empname;
    private Double salary;
    private Date deptId;

    public Emp() {
    }

    public Emp(Integer id, String empname, Double salary, Date deptId) {
        this.id = id;
        this.empname = empname;
        this.salary = salary;
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getDeptId() {
        return deptId;
    }

    public void setDeptId(Date deptId) {
        this.deptId = deptId;
    }
}
