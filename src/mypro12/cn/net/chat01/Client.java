package mypro12.cn.net.chat01;

import java.io.*;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 在线聊天室：客户端
 * @create 2020-06-02 20:54
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------------Client-------------------");
        // 1. 建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket  client = new Socket("localhost", 8888);
        // 2. 客户端发送消息
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String msg = console.readLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);

        // 3. 接收客户端发的消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        msg = dis.readUTF();
        System.out.println(msg);

        // 释放资源
        dos.close();
        dis.close();
        console.close();
        client.close();

    }
}
