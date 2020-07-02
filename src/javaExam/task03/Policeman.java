package javaExam.task03;

import java.util.Date;

/**
 * @author 张辉
 * @Description 警察类
 * @create 2020-07-02 22:29
 */
public class Policeman {

    /**
     * 警号
     * 姓名
     * 工资
     * 工作的日期
     */
    private int policeNumber;
    private String name;
    private double salary;
    private Date date;

    /**
     * 构造方法
     * @param policeNumber
     * @param name
     * @param salary
     */
    public Policeman(int policeNumber, String name, double salary) {
        this.policeNumber = policeNumber;
        this.name = name;
        this.salary = salary;
        this.date = new Date();
    }

    /**
     * policeNumber属性的访问器
     * @return
     */
    public int getPoliceNumber() {
        return policeNumber;
    }

    /**
     * name属性的访问器
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * salary属性的访问器
     * @return
     */
    public double getSalary() {
        return salary;
    }

    /**
     * date属性访问器
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * salary属性修改器
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * date属性修改器
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 重写的toString
     * @return
     */
    @Override
    public String toString() {
        return policeNumber + " + " + name + " + " + date + " + " + salary;
    }

}
