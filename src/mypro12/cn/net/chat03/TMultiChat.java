package mypro12.cn.net.chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 在线聊天室：服务端
 * 版本1.0：目标：实现一个客户可以正常发消息
 * 版本1.1：目标：发送多条消息
 * 版本2.0：目标：实现多个用户发送多条消息 (问题：客户必须等待之前的客户退出，才能够使用)
 * 版本2.1：目标：使用多线程，解决2.0版本的问题（问题：线程代码太多，不好维护，客户端读写没有分开，必须先写后读）
 * 版本3.0：目标：使用oop，解决版本2.1的问题
 * @create 2020-06-02 20:54
 */
public class TMultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------------Server-------------------");
        // 1. 指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);

        while (true) {
            // 2. 阻塞式等待连接 accept
            Socket client = server.accept(); // 监听端口
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }
    }

    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
            } catch (IOException e) {
                System.out.println("初始化Channel出错");
                release();
            }
        }

        // 接收消息
        private String receive() {
            String msg = ""; // 在处理之前先进行初始化，就可以避免空指异常
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("接收消息receive出错");
                release();
            }
            return msg;
        }

        // 发送消息
        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("发送消息send出错");
                release();
            }
        }

        // 释放资源
        private void release() {
            this.isRunning = false;
            ZhUtils.close(dos, dis, client);
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = receive(); // 接收消息
                if (!msg.equals("")) {
                    send(msg); // 发送消息
                }
            }
        }
    }
}
