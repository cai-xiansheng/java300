package gof23.factory.simpleFactory;

/**
 * @author 张辉
 * @Description 汽车工厂
 * @create 2020-07-26 10:09
 */
public class CarFactory {
    public static Car createCar(String type) {
        if ("奥迪".equals(type)) {
            return new Audi();
        } else if ("比亚迪".equals(type)) {
            return new Byd();
        } else {
            return null;
        }
    }
}
