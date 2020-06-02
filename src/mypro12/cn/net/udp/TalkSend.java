package mypro12.cn.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.Buffer;

/**
 * @author 张辉
 * @Description 多线程发送端，使用面向对象的封装
 * @create 2020-06-02 15:25
 */
public class TalkSend implements Runnable {
    private DatagramSocket client;
    private BufferedReader reader;
    private String toIP;
    private int toPort;
    public TalkSend(int port, String toIP, int toPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            client = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (true) {
            String data = null;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();
                // 封装成DatagramPacket 包裹，需要指定目的地
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                        new InetSocketAddress(this.toIP,this.toPort));
                client.send(packet);
                if (data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 释放资源
        client.close();
    }
}
