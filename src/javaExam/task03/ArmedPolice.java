package javaExam.task03;

/**
 * @author 张辉
 * @Description ArmedPolice 继承police和实现Employee
 * @create 2020-07-02 22:46
 */
public class ArmedPolice extends Policeman implements Employee{
    /**
     * 军队的名称
     * 军衔
     */
    private String army;
    private String rank;

    /**
     * 构造方法
     * @param policeNumber
     * @param name
     * @param salary
     * @param army
     * @param rank
     */
    public ArmedPolice(int policeNumber, String name, double salary, String army, String rank) {
        super(policeNumber, name, salary);
        this.army = army;
        this.rank = rank;
    }

    /**
     * 实现Employee的方法
     */
    @Override
    public void Raise() {
        this.setSalary(this.getSalary() * 1.3);
    }

    /**
     * 重写继承toString
     * @return
     */
    @Override
    public String toString() {
        return this.getPoliceNumber() + " + " + this.getName() + " + " + this.getDate() + " + " + this.getSalary() + " + " + army + " + " + rank;
    }
}
