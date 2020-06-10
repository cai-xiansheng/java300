package com.zh.webserver02;

/**
 * @author 张辉
 * @Description 服务器小脚本接口
 * @create 2020-06-07 13:48
 */
public interface Servlet {
    void servive(Request request,Response response);
}
