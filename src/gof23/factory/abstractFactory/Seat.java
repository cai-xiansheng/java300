package gof23.factory.abstractFactory;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-26 10:47
 */
public interface Seat {
    void message();
}

class LuxurySeat implements Seat {

    @Override
    public void message() {
        System.out.println("可以自动按摩！");
    }
}

class LowSeat implements Seat {

    @Override
    public void message() {
        System.out.println("不能自动按摩！");
    }
}
