package mypro12.cn.net.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author 张辉
 * @Description 基本类型 UDP服务端
 * 1. 使用DatagramSocket指定端口，创建接收端
 * 2. 将基本类型转成字节数组
 * 3. 封装成Datagrampacket 包裹，需要制定目的地
 * 4. 发送包裹send(DatagramPacket p)
 * 5. 释放资源
 * @create 2020-05-31 11:30
 */
public class UDPTypeClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送发启动中...");
        // 1. 使用DatagramSocket指定端口，创建接收端
        DatagramSocket client = new DatagramSocket(8888);
        // 2. 将基本类型转成字节数组
        // 写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        // 操作数据类型 + 数据
        dos.writeUTF("网络编程练习");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();


        byte[] datas = baos.toByteArray();
        // 3. 封装成Datagrampacket 包裹，需要制定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",9999));
        // 4. 发送包裹send(DatagramPacket p)
        client.send(packet);
        // 5. 释放资源
        client.close();
    }
}
