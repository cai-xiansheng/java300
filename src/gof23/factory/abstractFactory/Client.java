package gof23.factory.abstractFactory;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-26 10:53
 */
public class Client {
    public static void main(String[] args) {
        CarFactory factory = new LuxuryFactory();
        Engine e = factory.createEngine();
        e.run();
        e.start();
    }
}
