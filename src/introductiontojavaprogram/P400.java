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

    public MyInteger() {

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

        for (int i = 2; i <= (int)Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
