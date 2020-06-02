package mypro12.cn.net.udp;

/**
 * @author 张辉
 * @Description 加入多线程，实心双向交流，模拟在线咨询
 * @create 2020-06-02 16:22
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777, "localhost", 9999)).start();// 发送

        new Thread(new TalkReceive(8888, "老师")).start();// 接收

    }
}
