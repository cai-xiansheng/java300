package gof23.mediator;

/**
 * @author 张辉
 * @Description 中介者模式
 * @create 2020-07-27 23:05
 */
public class Client {
    public static void main(String[] args) {
        Mediator m = new President();

        Market market = new Market(m);
        Department devp = new Development(m);
        Finacial finacial = new Finacial(m);

    }
}
