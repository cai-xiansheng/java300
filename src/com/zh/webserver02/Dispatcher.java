package com.zh.webserver02;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 分发器
 * 加入状态内容处理 404 500 首页
 * @create 2020-06-08 11:00
 */
public class Dispatcher implements Runnable {
    private Socket client;
    private Request request;
    private Response response;

    public Dispatcher(Socket client) {
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
            if (request.getUrl().equals("") || request.getUrl() == null) {
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
                response.print(new String(is.readAllBytes()));
                response.pushToBrowser(200);
                is.close();
                return;
            }

            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            if (servlet != null) {
                servlet.servive(request, response);
                response.pushToBrowser(200);
            } else {
                //错误....
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
                response.print(new String(is.readAllBytes()));
                response.pushToBrowser(404);
                is.close();
            }
        } catch (Exception e) {
            try {
                response.print("错误500");
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
