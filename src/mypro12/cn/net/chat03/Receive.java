package mypro12.cn.net.chat03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 接收端：使用多线程封装了接收端
 * 1. 接收消息
 * 3. 释放资源
 * 4. 重写run()
 * @create 2020-06-02 22:23
 */
public class Receive implements Runnable {
    private DataInputStream dis ;
    private Socket client;
    private boolean isRunning;

    public Receive(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream()); // 从服务器get消息
            isRunning = true;
        } catch (IOException e) {
            System.out.println("客户端初始化Receive出错");
            release();
        }
    }

    private String receive (){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.out.println("客户端接收消息receive出错");
            release();
        }
        return msg;
    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = receive();
            if (!msg.equals("")) {
                System.out.println(msg);
            }
        }
    }

    private void release() {
        this.isRunning = false;
        ZhUtils.close(dis, client);
    }
}
