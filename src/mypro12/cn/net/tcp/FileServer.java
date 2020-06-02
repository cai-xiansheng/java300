package mypro12.cn.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 熟悉流程 创建服务器
 * 1. 指定端口，使用ServerSockt 创建服务器
 * 2. 阻塞式等待连接accept
 * 3. 操作：输入输出流操作
 * 4. 释放资源
 * @create 2020-06-02 16:42
 */
public class FileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("--------------server--------------------");
         // 1. 指定端口，使用ServerSockt 创建服务器
        ServerSocket server = new ServerSocket(8888);
         // 2. 阻塞式等待连接accept(监听端口)
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
         // 3. 操作：文件存储
        InputStream is = new BufferedInputStream(client.getInputStream());
        OutputStream os = new BufferedOutputStream(new FileOutputStream("tcp.png"));
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = is.read(flush)) != -1) {
            os.write(flush, 0, len);
        }
        os.flush();
         // 4. 释放资源

        client.close();
        server.close();
    }
}
