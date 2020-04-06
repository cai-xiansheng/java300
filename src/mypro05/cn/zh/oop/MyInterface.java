package mypro05.cn.zh.oop;

/**
 * @author 张辉
 * @Description interface(接口)
 * @create 2020-04-06 14:56
 */
public interface MyInterface {
    /**
     * 定义接口的详细说明：
     *       1. 访问修饰符：只能是public或默认。
     *       2. 接口名：和类名采用相同命名机制。
     *       3. extends：接口可以多继承。
     *       4. 常量：接口中的属性只能是常量，总是：public static final 修饰。不写也是。
     *       5. 方法：接口中的方法只能是：public abstract。 省略的话，也是public abstract。
     * 要点
     *       1. 子类通过implements来实现接口中的规范。
     *       2. 接口不能创建实例，但是可用于声明引用变量类型。
     *       3. 一个类实现了接口，必须实现接口中所有的方法，并且这些方法只能是public的。
     *       4. JDK1.7之前，接口中只能包含静态常量、抽象方法，不能有普通属性、构造方法、普通方法。
     *       5. JDK1.8后，接口中包含普通的静态方法。
     */

    /**public static final*/int Max_AGE = 100;
    /**public abstract*/void test01();
}


class MyClass implements MyInterface{

    @Override
    public void test01() {
        System.out.println(Max_AGE);
        System.out.println("MyInterface01");
    }
}