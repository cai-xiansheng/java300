package com.zh.webserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author 张辉
 * @Description
 * @create 2020-06-07 21:31
 */
public class Response {
    private BufferedWriter bw;
    // 正文
    private StringBuilder content;
    // 协议头(状态行于请求头 回车)信息
    private StringBuilder headInfo;
    private int len; //正文的字节数

    private final String BLACk = " ";
    private final String CRLF = "\r\n";

    private Response() {
        content = new StringBuilder();
        headInfo = new StringBuilder();
        len = 0;
    }

    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            headInfo = null;
        }
    }

    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    // 动态添加内容(流模式)
    public Response print(String info) {
        content.append(info);
        len += info.getBytes().length;
        return this;
    }

    public Response println(String info) {
        content.append(info);
        len += (info + CRLF).getBytes().length;
        return this;
    }

    // 推送响应信息
    public void pushToBrowser(int code) throws IOException {
        if (headInfo == null) {
            code = 505;
        }
        createHeadInfo(code);
        bw.append(headInfo.toString());
        bw.append(content);
        bw.flush();
    }

    // 构建头信息
    private void createHeadInfo(int code) {
        // 1. 响应行：HTTP/1.1 200 OK
        headInfo.append("HTTP/1.1").append(BLACk);
        headInfo.append(code).append(BLACk);
        switch (code) {
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 505:
                headInfo.append("Server Error").append(CRLF);
                break;
        }
        // 2. 响应头（最后一行存在空行）
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("zh Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:text/html").append(CRLF);
        headInfo.append("Content-length:").append(len).append(CRLF);
        headInfo.append(CRLF);

    }
}
