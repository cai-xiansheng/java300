package com.zh.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 使用ServerSocket简历与浏览器的连接
 * @create 2020-06-07 19:18
 */
public class Server01 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server01 server = new Server01();
        server.start();
        server.receive();
    }

    // 启动服务
    public void start() {
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            System.out.println("服务器启动失败...");
        }
    }

    // 接收处理连接
    public void receive() {
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接");
            // 获取请求协议
            InputStream is = client.getInputStream();
            byte[] datas = new byte[1024 * 1024];
            int len = is.read(datas);
            String requestInfo = new String(datas, 0, len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            System.out.println("客户端错误");
        }
    }

    // 关闭服务
    public void stop() {

    }
}
