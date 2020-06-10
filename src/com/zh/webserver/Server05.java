package com.zh.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 目标：封装响应信息
 * 1. 内容可以动态的添加
 * 2. 关注状态码，拼接好相应的协议信息
 * 目标：封装请求信息中的参数转为map
 * @create 2020-06-07 19:18
 */
public class Server05 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server05 server = new Server05();
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
            Request2 request = new Request2(client);

            Response response = new Response(client);
            // 关注内容
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("终于回来了" + request.getParameter("uname"));
            response.print("</body>");
            response.print("</html>");
            response.pushToBrowser(200);

        } catch (IOException e) {
            System.out.println("客户端错误");
        }
    }

    // 关闭服务
    public void stop() {

    }
}
