package gof23.strategy;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 9:34
 */
public class OldCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打八五折");
        return standardPrice * 0.85;
    }
}
