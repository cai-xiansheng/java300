package gof23.factory.abstractFactory;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-26 10:52
 */
public class LuxuryFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }
}
