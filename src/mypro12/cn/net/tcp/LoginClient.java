package mypro12.cn.net.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 客户端(单向)
 * @create 2020-06-02 17:25
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        System.out.println("------------------Client----------------------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String uname = br.readLine();
        System.out.println("请输入密码：");
        String upassword = br.readLine();
        //1. 建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost",8888);
        //2. 操作：输入输出流操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("uname=" + uname + "&" + "upassword=" + upassword);
        dos.flush();
        //3. 释放资源
        dos.close();
        client.close();
    }
}
