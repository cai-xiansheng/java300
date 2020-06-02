package mypro12.cn.net.udp;

/**
 * @author 张辉
 * @Description 加入多线程，实心双向交流，模拟在线咨询
 * @create 2020-06-02 16:24
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkReceive(9999, "学生")).start();// 接收

        new Thread(new TalkSend(5555, "localhost", 8888)).start();// 发送
    }
}
