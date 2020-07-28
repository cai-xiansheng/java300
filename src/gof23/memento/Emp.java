package gof23.memento;

/**
 * @author 张辉
 * @Description 源发器类
 * @create 2020-07-28 12:21
 */
public class Emp {
    private String eName;
    private int age;
    private double salary;


    // 进行备忘录操作
    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    // 进行数据恢复，恢复成指定备忘录的值
    public void recovery(EmpMemento Emt) {
        this.eName = Emt.geteName();
        this.age = Emt.getAge();
        this.salary = Emt.getSalary();
    }


    public Emp(String eName, int age, double salary) {
        this.eName = eName;
        this.age = age;
        this.salary = salary;
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
