package gof23.factory.simpleFactory;

/**
 * @author 张辉
 * @Description 简单工厂模式下
 * @create 2020-07-26 10:07
 */
public class Client02 {
    public static void main(String[] args) {
        Car c1 = CarFactory.createCar("奥迪");
        Car c2 = CarFactory.createCar("比亚迪");

        c1.run();
        c2.run();
    }
}
