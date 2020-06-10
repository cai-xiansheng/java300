package com.zh.webserver02;

/**
 * @author 张辉
 * @Description
 * @create 2020-06-07 13:50
 */
public class OthersServlet implements Servlet {

    @Override
    public void servive(Request request, Response response) {
        response.print("其他测试页面");
    }
}
