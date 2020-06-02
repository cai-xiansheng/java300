package mypro12.cn.net.chat03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author 张辉
 * @Description 发送端：使用多线程封装了发送端
 * 1. 发送消息
 * 2. 从控制台获取消息
 * 3. 释放资源
 * 4. 重写run()
 * @create 2020-06-02 22:23
 */
public class Send implements Runnable {
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning;

    public Send(Socket client) {
        this.client = client;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
            isRunning = true;
        } catch (IOException e) {
            System.out.println("初始化Send出错");
            this.release();
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = getStrFromConsole();
            if (!msg.equals("")) {
                send(msg);
            }
        }
    }

    private void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("客户端发送消息send出错");
            release();
        }
    }

    /**
     * 从控制台获取消息
     * @return
     */
    private String getStrFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("从控制台获取输入出错");
        }
        return "";
    }

    private void release() {
        this.isRunning = false;
        ZhUtils.close(dos, client);
    }
}
