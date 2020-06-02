package mypro12.cn.net.chat01;

import mypro12.cn.net.tcp.Server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 在线聊天室：服务端
 * 版本1.0：目标：实现一个客户可以正常发消息
 * @create 2020-06-02 20:54
 */
public class Chat {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------------Server-------------------");
        // 1. 指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        // 2. 阻塞式等待连接 accept
        Socket client = server.accept(); // 监听端口
        System.out.println("一个客户端建立了连接");

        // 3. 接收消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();

        // 4. 返回消息
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(datas);
        dos.flush();

        // 释放资源
        dos.close();
        dis.close();
        client.close();
    }
}
