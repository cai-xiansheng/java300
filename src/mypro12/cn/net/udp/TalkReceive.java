package mypro12.cn.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author 张辉
 * @Description 接收端，使用面向对象封装
 * @create 2020-06-02 15:26
 */
public class TalkReceive implements Runnable{
    private DatagramSocket server ;
    private String from;

    public TalkReceive(int port, String from) {
        this.from = from;
        try {
            server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            byte[] contaienr = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(contaienr, 0, contaienr.length);
            try {
                server.receive(packet);
                byte[] datas = packet.getData();
                int len = packet.getLength();
                String data = new String(datas, 0 ,len);
                System.out.println(from + " --> " + data);
                if (data.equals("bye")) {
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        server.close();

    }
}
