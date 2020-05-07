package introductiontojavaprogram;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    public static void testTriangle() {
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
        Triangle tr = new Triangle(side1, side2, side3);
        tr.setColor(color);
        tr.setFilled(filled);
        System.out.println("面积：" + tr.getArea());
        System.out.println("周长：" + tr.getPerimeter());
        System.out.println("颜色：" + tr.getColor());
        System.out.println("三角型是否填充：" + tr.isFilled());

    }

    public static void testPerson() {
        Person person = new Person("小明","长沙","1852342","1232@qq.com");
        Student stu = new Student("小红","山西","1823342","2143@qq.com",StudentStatus.junior);
        Employee emp = new Employee("小强","西安","1865431","1234@qq.com","办公剖1号",5000,new MyDate(2010,11,28));
        Faculty fac = new Faculty("小易","北京","1823453","3412@qq.com","前门大街", 50000,new MyDate(2013,11,28),"教学楼一楼","教授");
        Staff sta = new Staff("小华","上海","1893211","2345@qq.com","办公楼2号",4000,new MyDate(2011,11,28),"班长");
        System.out.println(person.toString());
        System.out.println(stu.toString());
        System.out.println(emp.toString());
        System.out.println(fac.toString());
        System.out.println(sta.toString());
    }

    public static void TestAccount(){
        Account ac = new Account(101,10000);
        CheckingAccount cac = new CheckingAccount(102,20000,2000);
        SavingAccount sac = new SavingAccount(103,20000);
        System.out.println(ac.toString());
        System.out.println(cac.toString());
        System.out.println(sac.toString());

    }
}


/**
 * (Subclasses of Account) In Programming Exercise 9.7, the Account class was defined to model a bank account.
 * An account has the properties account number, balance, annual interest rate, and date created, and methods to deposit and withdraw funds.
 * Create two subclasses for checking and saving accounts.
 * A checking account has an overdraft limit, but a savings account cannot be overdrawn.
 * Draw the UML diagram for the classes and then implement them.
 * Write a test program that creates objects of Account, SavingsAccount, and CheckingAccount and invokes their toString() methods.
 */

class CheckingAccount extends Account{
    int overdraft;

    public CheckingAccount(int id, double balance, int overdraft) {
        super(id, balance);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double money) {
        super.withdraw(money);
        if (this.getBalance() < this.overdraft) {
            // 出界
            this.deposit(money);
            System.out.println("超过透支额度！");
        }
    }

    public int getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "id=" + this.getId() +
                ", balance=" + this.getBalance() +
                ", annualInterestRate=" + this.getAnnualInterestRate() +
                ", dateCreated=" + this.getDateCreated() +
                "overdraft=" + this.getOverdraft() +
                '}';
    }
}

class SavingAccount extends Account{

    public SavingAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double money) {
        super.withdraw(money);
        if (this.getBalance() < 0) {
            this.deposit(money);
            System.out.println("此账户不能透支！");
        }
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "id=" + this.getId() +
                ", balance=" + this.getBalance() +
                ", annualInterestRate=" + this.getAnnualInterestRate() +
                ", dateCreated=" + this.getDateCreated() +
                '}';
    }
}



/**
 * (The Person, Student, Employee, Faculty, and Staff classes)
 * Design a class named Person and its two subclasses named Student and Employee.
 * Make Faculty and Staff subclasses of Employee.
 * A person has a name, address, phone number, and email address.
 * A student has a class status (freshman, sophomore, junior, or senior). Define the status as a constant.
 * <p>
 * An employee has an office, salary, and date hired. Use the MyDate class defined in Programming Exercise 10.14 to create an object for date hired.
 * <p>
 * A faculty member has office hours and a rank.
 * A staff member has a title.
 * Override the toString method in each class to display the class name and the person’s name.
 * Draw the UML diagram for the classes and implement them.
 * Write a test program that creates a Person, Student, Employee, Faculty, and Staff, and invokes their toString() methods.
 */

class Person {
    private String name;
    private String address;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person() {
    }

    public Person(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                '}';
    }
}

enum StudentStatus {
    /**
     * 大一
     */
    freshman,
    /**
     * 大二
     */
    junior,
    /**
     * 大三
     */
    senior,
    /**
     * 大四
     */
    sophomore
}

class Student extends Person {
    private final StudentStatus studentStatus;

    public Student(String name, String address, String phone, String email, StudentStatus studentStatus) {
        super(name, address, phone, email);
        this.studentStatus = studentStatus;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", studentStatus=" + this.getStudentStatus() + '\'' +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(long elapsedTime) {
        Date dt = new Date(elapsedTime);
        this.year = dt.getYear();
        this.month = dt.getMonth();
        this.day = dt.getDay();
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
        Date dt = new Date(elapsedTime);
        this.year = dt.getYear();
        this.month = dt.getMonth();
        this.day = dt.getDay();
    }
}

class Employee extends Person {
    private String office;
    private int salary;
    private MyDate dateHired;

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public Employee() {
    }

    public Employee(String name, String address, String phone, String email, String office, int salary, MyDate dateHired) {
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", office='" + this.getOffice() + '\'' +
                ", salary='" + this.getSalary() + '\'' +
                ", dateHired=" + this.getDateHired() + '\'' +
                '}';
    }
}

class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String officeHours, String rank) {
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Faculty() {
    }

    public Faculty(String name, String address, String phone, String email, String office, int salary, MyDate dateHired, String officeHours, String rank) {
        super(name, address, phone, email, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", office='" + this.getOffice() + '\'' +
                ", salary='" + this.getSalary() + '\'' +
                ", dateHired=" + this.getDateHired() + '\'' +
                "officeHours='" + this.getOfficeHours() + '\'' +
                ", rank='" + this.getRank() + '\'' +
                '}';
    }
}

class Staff extends Employee {
    private String little;

    public String getLittle() {
        return little;
    }

    public void setLittle(String little) {
        this.little = little;
    }

    public Staff(String name, String address, String phone, String email, String office, int salary, MyDate dateHired, String little) {
        super(name, address, phone, email, office, salary, dateHired);
        this.little = little;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", office='" + this.getOffice() + '\'' +
                ", salary='" + this.getSalary() + '\'' +
                ", dateHired=" + this.getDateHired() + '\'' +
                "little='" + this.getLittle() + '\'' +
                '}';
    }
}



class GeometricObject {
    String color;
    boolean filled;
    Date dataCreated;

    public GeometricObject() {
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
        return "created on " + dataCreated + "\ncolor:" + color + " and filled: " + filled;
    }
}

class Triangle extends GeometricObject {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;

    public Triangle() {

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

    public double getArea() {
        double w = (getSide1() + getSide2() + getSide3()) / 2;
        return Math.sqrt(w * (w - getSide1()) * (w - getSide2()) * (w - getSide3()));
    }

    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
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
