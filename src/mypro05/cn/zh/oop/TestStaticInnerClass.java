package mypro05.cn.zh.oop;

/**
 * @author 张辉
 * @Description 测试静态内部类
 * @create 2020-04-06 16:31
 */
public class TestStaticInnerClass {
    public static void main(String[] args) {
        Outer2.Inner2 inner = new Outer2.Inner2();
        /**
         * 静态内部类不依托于外部类
         */
    }
}

class Outer2{

    static class Inner2{

    }
}
