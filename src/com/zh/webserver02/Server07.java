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
 * @create 2020-06-07 19:18
 */
public class Server07 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server07 server = new Server07();
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
            Request request = new Request(client);
            // 获取响应协议
            Response response = new Response(client);

            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            if (servlet != null) {
                servlet.servive(request, response);
                response.pushToBrowser(200);
            } else {
                //错误....
                response.pushToBrowser(404);
            }

        } catch (IOException e) {
            System.out.println("客户端错误");
        }
    }

    // 关闭服务
    public void stop() {

    }
}
