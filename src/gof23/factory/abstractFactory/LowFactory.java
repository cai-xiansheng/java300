package gof23.factory.abstractFactory;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-26 10:53
 */
public class LowFactory  implements CarFactory{
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}
