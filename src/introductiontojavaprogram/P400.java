package introductiontojavaprogram;

import mypro05.cn.zh.oop.MyInterface;

/**
 * @author 张辉
 * @Description 实验
 * @create 2020-04-19 13:32
 */
public class P400 {
    public static void main(String[] args) {

    }
}

class MyInteger {
    int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        if (value % 2 == 0) {
            return true;
        }
        return false;
    }

    public boolean isOdd() {
        if (value % 2 != 0) {
            return true;
        }
        return false;
    }

    public boolean isPrime() {
        if (value <= 3) {
            return value > 1;
        }

        for (int i = 2; i <= (int) Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }


}

class MyPoint{
    double x;
    double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint m) {
        double x_ = Math.abs(m.getX()-this.x);
        double y_ = Math.abs(m.getY()-this.y);
        return Math.sqrt(Math.pow(x_,2)+Math.pow(y_,2));
    }

    public double distance(double x,double y) {
        double x_ = Math.abs(x-this.x);
        double y_ = Math.abs(y-this.y);
        return Math.sqrt(Math.pow(x_,2)+Math.pow(y_,2));
    }
}
