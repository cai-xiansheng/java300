package introductiontojavaprogram;


/**
 * @author 张辉
 * @Description 实验
 * @create 2020-04-19 13:32
 */
public class P400 {
    public static void main(String[] args) {
        //testMyPoint();
        testMyInteger();
    }

    public static void testMyPoint() {
        MyPoint m1 = new MyPoint(0, 0);
        MyPoint m2 = new MyPoint(10, 30.5);
        System.out.println(m1.distance(m2));
    }

    public static void testMyInteger() {
        MyInteger m1 = new MyInteger(16);
        System.out.println("getValue:" + m1.getValue());

        boolean b = true;
        b = MyInteger.isEven(16);
        System.out.println("isEven(int):" + b);
        b = MyInteger.isOdd(16);
        System.out.println("isOdd(int):" + b);

        b = MyInteger.isPrime(16);
        System.out.println("isPrime(int):" + b);

        b = MyInteger.isEven(m1);
        System.out.println("isEven(MyInteger):" + b);

        b = MyInteger.isOdd(m1);
        System.out.println("isOdd(MyInteger):" + b);

        b = MyInteger.isPrime(m1);
        System.out.println("isPrime(MyInteger):" + b);

        b = m1.equals(16);
        System.out.println("equals(int):" + b);

        MyInteger m2 = new MyInteger(16);
        b = m1.equals(m2);
        System.out.println("equals(MyInteger):" + b);


        char[] ch = new char[]{'a', 'b', 'c'};
        System.out.println(MyInteger.parselnt(ch));

        String str = new String();
        str = "abc";
        System.out.println(MyInteger.parselnt(str));
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

    public static boolean isEven(int value) {
        if (value % 2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isOdd(int value) {
        if (value % 2 != 0) {
            return true;
        }
        return false;
    }

    public static boolean isPrime(int value) {
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

    public static boolean isEven(MyInteger my) {
        if (my.value % 2 == 0) {
            return true;
        }
        return true;
    }

    public static boolean isOdd(MyInteger my) {
        if (my.value % 2 != 0) {
            return true;
        }
        return false;
    }

    public static boolean isPrime(MyInteger my) {
        if (my.value <= 3) {
            return my.value > 1;
        }

        for (int i = 2; i <= (int) Math.sqrt(my.value); i++) {
            if (my.value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(int value) {
        if (this.value != value) {
            return false;
        }
        return true;
    }

    public boolean equals(MyInteger my) {
        if (this.value != my.value) {
            return false;
        }
        return true;
    }

    public static int parselnt(char[] ch) {
        int result = 0;
        for (char i : ch) {
            result += (int) i;
        }
        return result;
    }

    public static int parselnt(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += (int) str.charAt(i);
        }
        return result;
    }
}

class MyPoint {
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
        double x_ = Math.abs(m.getX() - this.x);
        double y_ = Math.abs(m.getY() - this.y);
        return Math.sqrt(Math.pow(x_, 2) + Math.pow(y_, 2));
    }

    public double distance(double x, double y) {
        double x_ = Math.abs(x - this.x);
        double y_ = Math.abs(y - this.y);
        return Math.sqrt(Math.pow(x_, 2) + Math.pow(y_, 2));
    }
}
