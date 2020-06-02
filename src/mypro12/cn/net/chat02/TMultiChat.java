package mypro12.cn.net.chat02;

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

            new Thread(()->{
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean isRunning = true;
                while (isRunning) {

                    String datas = null;
                    try {
                        // 3. 接收消息
                        datas = dis.readUTF();
                        // 4. 返回消息
                        dos.writeUTF(datas);
                        dos.flush();
                    } catch (IOException e) {
                        //e.printStackTrace();
                        isRunning = false; // 出错之后停止线程
                    }



                }


                // 释放资源
                try {
                    if (dos != null) {
                        dos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (dos != null) {
                        dis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (dos != null) {
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }).start();



        }
    }
}
