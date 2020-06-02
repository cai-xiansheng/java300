package mypro12.cn.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 服务器端（单向）
 * @create 2020-06-02 17:24
 */
public class LoginServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------Server---------------");
        // 1. 指定端口，使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        // 2. 阻塞式等待
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        // 3. 操作输入输出流操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        // 分析
        String[] dataArray = data.split("&");
        for (String info: dataArray) {
            String[] userInfo = info.split("=");
            if (userInfo[0].equals("uname")) {
                System.out.println("你的用户名：" + userInfo[1]);
            } else if (userInfo[0].equals("upassword")) {
                System.out.println("你的密码为：" + userInfo[1]);
            }
        }
        // 4. 释放资源
        dis.close();
        client.close();
    }
}
