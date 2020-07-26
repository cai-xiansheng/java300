package gof23.factory.factorymethods;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-26 10:24
 */
public class AudiFactory implements CarFactory{

    @Override
    public Car createCar() {
        return new Audi();
    }
}
