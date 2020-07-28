package gof23.state;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 11:12
 */
public class Client {
    public static void main(String[] args) {
        HomeContext ctx = new HomeContext();

        ctx.setState(new FreeState());
        ctx.setState(new BookedState());


    }
}
