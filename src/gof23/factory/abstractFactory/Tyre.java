package gof23.factory.abstractFactory;

/**
 * @author 张辉
 * @Description 轮胎
 * @create 2020-07-26 10:49
 */
public interface Tyre {
    void revolve();
}

class LuxuryTyre implements Tyre {

    @Override
    public void revolve() {
        System.out.println("高速，不磨损");
    }
}

class LowTyre implements Tyre {

    @Override
    public void revolve() {
        System.out.println("高速，磨损");
    }
}
