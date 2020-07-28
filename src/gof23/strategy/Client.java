package gof23.strategy;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 9:43
 */
public class Client {
    public static void main(String[] args) {
        Strategy s1 = new OldCustomerManyStrategy();
        Context ctx = new Context(s1);

        ctx.pringPrice(998);
    }
}
