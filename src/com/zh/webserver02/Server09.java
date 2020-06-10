package com.zh.webserver02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 目标：封装响应信息
 * 1. 内容可以动态的添加
 * 2. 关注状态码，拼接好相应的协议信息
 * 目标：封装请求信息中的参数转为map
 * 目标：加入了Servlet解耦了业务代码
 * 目标：整合配置文件
 * 目标：多线程处理加入分发器
 * 目标：处理404,505，首页
 * @create 2020-06-07 19:18
 */
public class Server09 {
    private ServerSocket serverSocket;
    private boolean isRunning;

    public static void main(String[] args) {
        Server09 server = new Server09();
        server.start();
    }

    // 启动服务
    public void start() {
        try {
            serverSocket = new ServerSocket(8888);
            isRunning = true;
            receive();
        } catch (IOException e) {
            System.out.println("服务器启动失败...");
            stop();
        }
    }

    // 接收处理连接
    public void receive() {
        while (isRunning) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接");
                // 多线程处理
                new Thread(new Dispatcher(client)).start();
            } catch (IOException e) {
                System.out.println("客户端错误");
            }
        }
    }

    // 关闭服务
    public void stop() {
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器已停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
