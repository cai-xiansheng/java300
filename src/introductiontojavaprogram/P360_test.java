package introductiontojavaprogram;


import java.util.Date;

/**
 * @author 张辉
 * @Description
 * @create 2020-04-16 20:48
 */
public class P360_test {
    public static void main(String[] args) {
        testFan();
    }

    public static void testFan() {
        Fan f = new Fan();
        Fan f2 = new Fan();
        f.setSpeed(Fan.FAST);
        f.setRadius(10);
        f.setColor("yellow");
        f.setOn(true);
        f2.setSpeed(Fan.MEDIUM);
        f2.setRadius(5);
        f2.setColor("blue");
        f2.setOn(false);
        System.out.println(f.toString());
        System.out.println(f2.toString());
    }

    public static void testMoney() {
        Account a = new Account(1122, 20000);
        a.setAnnualInterestRate(0.045);
        a.withdraw(2500);
        a.deposit(3000);
        System.out.println(a.getBalance());
        System.out.println(a.getMonthlyInterestRate());
        System.out.println(a.getDateCreated());
    }

    public static void test() {
        Rectangle r = new Rectangle(4, 40);
        System.out.println(r.getWidth());
        System.out.println(r.getHeight());
        System.out.println(r.getArea());
        System.out.println(r.getPerimeter());
        Rectangle r2 = new Rectangle(3.5, 35.9);
        System.out.println(r2.getWidth());
        System.out.println(r2.getHeight());
        System.out.println(r2.getArea());
        System.out.println(r2.getPerimeter());
    }

}

class Rectangle {
    private double width = 1;
    private double height = 1;

    public Rectangle() {
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {

        return (double) width * height;
    }

    public double getPerimeter() {
        return (double) (2 * (width + height));
    }
}

class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;

    public Account() {
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return (double) (this.balance * this.annualInterestRate / 12);
    }

    public void withdraw(double money) {
        this.balance -= money;
    }

    public void deposit(double money) {
        this.balance += money;
    }
}

class Fan {
    static final int SlOW = 1;
    static final int MEDIUM = 2;
    static final int FAST = 3;
    private int speed = SlOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {

    }

    @Override
    public String toString() {

        if (on) {
            return "speed=" + speed + ", color=" + color + ", radius=" + radius;
        } else {
            return "fan is off" + ", color=" + color + ", radius=" + radius;
        }
    }
}
