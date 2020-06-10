package com.zh.webserver02;

import java.io.IOException;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 分发器
 * @create 2020-06-08 11:00
 */
public class Dispatcher02 implements Runnable {
    private Socket client;
    private Request request;
    private Response response;

    public Dispatcher02(Socket client) {
        this.client = client;
        try {
            // 获取请求协议
            // 获取响应协议
            request = new Request(client);
            response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }

    @Override
    public void run() {
        try {
            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            if (servlet != null) {
                servlet.servive(request, response);
                response.pushToBrowser(200);
            } else {
                //错误....
                response.pushToBrowser(404);
            }
        } catch (Exception e) {
            try {
                response.pushToBrowser(500);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        release();
    }

    // 释放资源
    private void release() {
        try {
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
