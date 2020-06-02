package mypro12.cn.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 客户端（双向），多个客户端请求
 * @create 2020-06-02 17:50
 */
public class LoginMultiClient2 {
    public static void main(String[] args) throws IOException {
        System.out.println("------------------Client----------------------");
        //1. 建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost", 8888);
        //2. 操作：输入输出流操作，先请求，后响应
        new Send(client).send();

        new Receive(client).receive();

        client.close();
    }

    // 发送
    static class Send {
        private Socket client;
        private DataOutputStream dos;
        private BufferedReader br;
        private String msg;

        private String init() {
            try {
                System.out.println("请输入用户名：");
                String uname = br.readLine();
                System.out.println("请输入密码：");
                String upassword = br.readLine();
                return "uname=" + uname + "&" + "upassword=" + upassword;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        public Send(Socket client) {
            br = new BufferedReader(new InputStreamReader(System.in));
            this.client = client;
            msg = init();
            try {
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void send() {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 接收
    static class Receive {
        private Socket client;
        private DataInputStream dis ;

        public Receive(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void receive() {
            try {
                String result = dis.readUTF();
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //3. 释放资源
    }
}
