package gof23.state;

/**
 * @author 张辉
 * @Description 空闲状态
 * @create 2020-07-28 11:07
 */
public class FreeState implements State {
    @Override
    public void handle() {
        System.out.println("房间空闲，没人住！");
    }
}
