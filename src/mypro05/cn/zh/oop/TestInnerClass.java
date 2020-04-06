package mypro05.cn.zh.oop;

/**
 * @author 张辉
 * @Description 测试非静态内部类
 * @create 2020-04-06 16:20
 */
public class TestInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();

        /**
         * 上边是创建外部类
         * 下边创建内部类
         *
         * 非静态内部类可以直接访问外部类成员，但是外部类不能访问非静态内部类的成员
         * 非静态内部类不能有静态方法、静态属性和静态初始化块。
         * 外部类的静态方法、静态代码块不能访问非静态内部类，包括不能使用非静态内部类定义变量、创建实例。
         */
        Outer.Inner inner = new Outer().new Inner();

        inner.show();
    }
}

class Outer {
    private int age = 10;

    public void testOuter() {
        System.out.println("Outer.testOuter");
    }

    class Inner {
        int age = 20;
        public void show() {
            int age = 30;
            System.out.println("外部类的成员变量age:" + Outer.this.age);
            System.out.println("内部类的成员变量age:" + this.age);
            System.out.println("局部变量age:" + age);
        }
    }
}