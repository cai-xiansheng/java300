package gof23.state;

/**
 * @author 张辉
 * @Description 预定状态
 * @create 2020-07-28 11:07
 */
public class BookedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已预定，别人不能定！");
    }
}
