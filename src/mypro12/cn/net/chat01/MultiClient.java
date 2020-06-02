package mypro12.cn.net.chat01;

import java.io.*;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 在线聊天室：客户端
 * 版本1.0：目标：实现一个客户可以正常发消息
 * 版本1.1：目标：发送多条消息
 * @create 2020-06-02 20:54
 */
public class MultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------------Client-------------------");
        // 1. 建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket  client = new Socket("localhost", 8888);
        // 2. 客户端发送消息
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in)); // 输入
        DataOutputStream dos = new DataOutputStream(client.getOutputStream()); // 发送给服务器
        DataInputStream dis = new DataInputStream(client.getInputStream()); // 从服务器get消息
        boolean isRunning = true;
        while (isRunning) {
            String msg = console.readLine();
            dos.writeUTF(msg);

            // 3. 接收客户端发的消息
            msg = dis.readUTF();
            System.out.println(msg);
        }
        // 释放资源
        dos.close();
        dis.close();
        console.close();
        client.close();

    }
}
