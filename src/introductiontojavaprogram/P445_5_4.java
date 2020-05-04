package introductiontojavaprogram;


import java.util.Date;
import java.util.Scanner;

/**
 * @author 张辉
 * @Description java 实验
 * @create 2020-05-04 19:24
 */
public class P445_5_4 {

    public static void main(String[] args) {
        testTriangle();
    }

    public static void testTriangle(){
        System.out.println("请输入三角形的三条边(空格隔开）：");
        Scanner sc = new Scanner(System.in);
        double side1 = sc.nextInt();
        double side2 = sc.nextInt();
        double side3 = sc.nextInt();
        System.out.println("请输入三角形的颜色：");
        String color = sc.next();
        System.out.println("请输入一个布尔值来指示三角形是否填满：");
        boolean filled = sc.nextBoolean();
        sc.close();
        Triangle tr = new Triangle(side1,side2,side3);
        tr.setColor(color);
        tr.setFilled(filled);
        System.out.println("面积："+tr.getArea());
        System.out.println("周长："+tr.getPerimeter());
        System.out.println("颜色：" + tr.getColor());
        System.out.println("三角型是否填充：" + tr.isFilled());

    }
}
/**
 * (Person、Student、Employee、Faculty和Staff类)设计一个名为Person的
 * 类及其两个名为Student和Employee的子类。将Faculty and Staff 划分为雇员的子类。
 * 一个人有名字、地址、电话号码和电子邮件地址。学生有班级地位(大一、大二
 * 、大三、大四)。将状态定义为常量。雇员有自己的办公室、薪水和工作日期。
 * 使用编程练习10.14中定义的MyDate类为date hired创建一个对象。教员有办
 * 公时间和职级。工作人员有头衔。覆盖每个类中的toString方法以显示类名和人
 * 员名。绘制类的UML图并实现它们。编写一个测试程序，创建Person、Student、
 * Employee、Faculty和Staff，并调用它们的toString()方法。
 */

class Person{
    String name;
    String address;
    String telephone;
    String email;
}

class Student extends Person{
    private final String status = "大一";
    
}

class Employee extends Person{
    String office;
    String salary;

}

class Faculty extends Employee{

}

class Staff extends Employee{

}


class GeometricObject{
    String color;
    boolean filled;
    Date dataCreated;

    public GeometricObject(){
        dataCreated = new Date();
    }

    public GeometricObject(String color, boolean filled) {
        dataCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDataCreated() {
        return dataCreated;
    }

    @Override
    public String toString() {
        return "created on "+ dataCreated + "\ncolor:" + color + " and filled: " + filled;
    }
}

class Triangle extends GeometricObject{
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;

    public Triangle(){

    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea(){
        double w = (getSide1()+getSide2()+getSide3())/2;
        return Math.sqrt(w*(w-getSide1())*(w-getSide2())*(w-getSide3()));
    }

    public double getPerimeter(){
        return getSide1()+getSide2()+getSide3();
    }

    @Override
    public String toString() {
        return "Triangle:" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}
