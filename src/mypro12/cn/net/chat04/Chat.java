package mypro12.cn.net.chat04;

import mypro09.cn.zh.mycollection.ZhArrayList;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 张辉
 * @Description 在线聊天室：服务端
 * 版本1.0：目标：实现一个客户可以正常发消息
 * 版本1.1：目标：发送多条消息
 * 版本2.0：目标：实现多个用户发送多条消息 (问题：客户必须等待之前的客户退出，才能够使用)
 * 版本2.1：目标：使用多线程，解决2.0版本的问题（问题：线程代码太多，不好维护，客户端读写没有分开，必须先写后读）
 * 版本3.0：目标：使用oop，解决版本2.1的问题
 * 版本4.0：目标：加入容器，实现群聊
 * @create 2020-06-02 20:54
 */
public class Chat {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();
    // CopyWiterArrayList 可以一边读一边写，（解决并发）


    public static void main(String[] args) throws IOException {
        System.out.println("-----------------Server-------------------");
        // 1. 指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);

        while (true) {
            // 2. 阻塞式等待连接 accept
            Socket client = server.accept(); // 监听端口
            System.out.println("一个客户端建立了连接");
            Channel c = new Channel(client);
            all.add(c); // 使用容器管理所有成员
            new Thread(c).start();
        }
    }

    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        private String name;

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
                // 获取名称
                name = receive();
                // 欢迎来到
                this.send("欢迎来到！");
                sendOthers(this.name + "来到了聊天室", true);
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

        /**
         * 群聊：获取自己的消息，发给其他人
         * @param msg
         */
        private void sendOthers(String msg, boolean isSys) {
            for (Channel other:all) {
                if (other == this) {
                    // 自己
                    continue;
                }
                if (!isSys) {
                    other.send(this.name + "说：" +msg); // 群聊消息
                } else {
                    other.send(msg);  // 系统消息
                }
            }
        }

        // 释放资源
        private void release() {
            this.isRunning = false;
            ZhUtils.close(dos, dis, client);
            all.remove(this);
            sendOthers(this.name+"离开了大家庭！",true);
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = receive(); // 接收消息
                if (!msg.equals("")) {
                    //send(msg); // 发送消息
                    sendOthers(msg, false);
                }
            }
        }
    }
}
