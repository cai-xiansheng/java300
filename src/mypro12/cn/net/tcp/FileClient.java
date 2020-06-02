package mypro12.cn.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 熟悉流程 创建客户端
 * 1. 建立连接：使用Socket创建客户端 + 服务的地址和端口
 * 2. 操作：输入输出流操作
 * 3. 释放资源
 * @create 2020-06-02 16:47
 */
public class FileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("----------------client-----------------");
        // 1.建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost",8888);
        // 2.操作：文件上传
        InputStream is = new BufferedInputStream(new FileInputStream("zhifeiji.png"));
        OutputStream os = new BufferedOutputStream(client.getOutputStream());
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = is.read(flush)) != -1) {
            os.write(flush, 0, len);
        }
        os.flush();
        // 3.释放资源
        os.close();
        is.close();
        client.close();
    }
}
