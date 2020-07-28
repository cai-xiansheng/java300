package gof23.state;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 11:10
 */
public class HomeContext {
    private State state;

    public void setState(State s) {
        System.out.println("修改状态！");
        state = s;
        state.handle();
    }
}
