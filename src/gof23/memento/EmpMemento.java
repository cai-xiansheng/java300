package gof23.memento;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 12:23
 */
public class EmpMemento {
    private String eName;
    private int age;
    private double salary;

    public EmpMemento(Emp emp) {
        this.eName = emp.geteName();
        this.age = emp.getAge();
        this.salary = emp.getSalary();
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
