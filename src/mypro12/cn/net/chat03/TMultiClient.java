package mypro12.cn.net.chat03;

import java.io.*;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 在线聊天室：客户端
 * 版本1.0：目标：实现一个客户可以正常发消息
 * 版本1.1：目标：发送多条消息
 * 版本2.0：目标：实现多个用户发送多条消息 (问题：客户必须等待之前的客户退出，才能够使用)
 * 版本2.1：目标：使用多线程，解决2.0版本的问题（问题：线程代码太多，不好维护，客户端读写没有分开，必须先写后读）
 * 版本3.0：目标：使用oop，解决版本2.1的问题
 * @create 2020-06-02 20:54
 */
public class TMultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------------Client-------------------");
        // 1. 建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket  client = new Socket("localhost", 8888);
        // 2. 客户端发送消息
        new Thread(new Send(client)).start();
        new Thread(new Receive(client)).start();

    }

}
