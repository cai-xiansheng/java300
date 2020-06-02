package mypro12.cn.net.tcp;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 服务端（双向）
 * @create 2020-06-02 17:50
 */
public class LoginMultiServer2 {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------Server---------------");
        // 1. 指定端口，使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        boolean isRunning = true;
        // 2. 阻塞式等待
        while (isRunning) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }
        server.close();
    }

    static class Channel implements Runnable {
        private Socket client;
        // 输入流
        private DataInputStream dis = null;
        // 输出流
        private DataOutputStream dos = null;
        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                // 如果出异常
                release();
            }
        }

        // 接收数据使用
        private String receive() {
            String datas = null;
            try {
                datas= dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datas;
        }

        // 发送数据使用
        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 可以把所有打开的资源传递到这去，然后就可以关闭
        private void close(Closeable...ios) {
            for (Closeable io:ios) {
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void release() {
            // 4. 释放资源
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            // 3. 操作输入输出流操作

            String uname = "";
            String upassword = "";
            // 分析
            String[] dataArray = receive().split("&");
            for (String info : dataArray) {
                String[] userInfo = info.split("=");
                if (userInfo[0].equals("uname")) {
                    System.out.println("你的用户名：" + userInfo[1]);
                    uname = userInfo[1];
                } else if (userInfo[0].equals("upassword")) {
                    System.out.println("你的密码为：" + userInfo[1]);
                    upassword = userInfo[1];
                }
            }
            // 输出
            if (uname.equals("zhangsan") && upassword.equals("123456")) {
                // 成功
                send("登陆成功！欢迎使用！");
            } else {
                // 失败
                send("用户名或密码错误！");
            }
            release();

        }


    }

}
