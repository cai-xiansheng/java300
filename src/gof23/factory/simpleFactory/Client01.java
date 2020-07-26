package gof23.factory.simpleFactory;

/**
 * @author 张辉
 * @Description 测试在没有工厂模式的情况下
 * @create 2020-07-26 10:07
 */
public class Client01 {
    public static void main(String[] args) {
        Car c1 = new Audi();
        Car c2 = new Byd();

        c1.run();
        c2.run();
    }
}
