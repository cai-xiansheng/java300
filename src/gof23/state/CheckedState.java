package gof23.state;

/**
 * @author 张辉
 * @Description 已入住状态
 * @create 2020-07-28 11:07
 */
public class CheckedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已入住，请勿打扰！");
    }
}
