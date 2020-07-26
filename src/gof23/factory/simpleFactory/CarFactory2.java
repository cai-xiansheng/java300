package gof23.factory.simpleFactory;

/**
 * @author 张辉
 * @Description 汽车工厂
 * @create 2020-07-26 10:09
 */
public class CarFactory2 {
    public static Car createAudi() {
        return new Audi();
    }
    public static Car createByd() {
        return new Byd();
    }
}
