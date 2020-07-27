package gof23.proxy.staticProxy;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 11:51
 */
public class Client {
    public static void main(String[] args) {
        Star real = new RealStar();
        Star proxy = new ProxyStar(real);
        proxy.confer();
        proxy.signContract();
        proxy.bookTicker();
        proxy.sing();
        proxy.collectMoney();
    }
}
