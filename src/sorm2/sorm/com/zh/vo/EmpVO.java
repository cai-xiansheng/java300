package sorm2.sorm.com.zh.vo;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-11 15:40
 */
public class EmpVO {
    //select e.id,e.empname,e.salary + e.bonus salary,age,d.dname deptName,d.address deptAddr
    //from emp e join dept d on e.deptId = d.id;
    private Integer id;
    private String empname;
    private Double salary;
    private Integer age;
    private String deptName;
    private String deptAddr;

    public EmpVO() {
    }

    public EmpVO(Integer id, String empname, Double salary, Integer age, String deptName, String deptAddr) {
        this.id = id;
        this.empname = empname;
        this.salary = salary;
        this.age = age;
        this.deptName = deptName;
        this.deptAddr = deptAddr;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddr() {
        return deptAddr;
    }

    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr;
    }
}
