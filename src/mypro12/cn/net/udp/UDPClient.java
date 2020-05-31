package mypro12.cn.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author 张辉
 * @Description 基本流程 UDP服务端
 * 1. 使用DatagramSocket指定端口，创建接收端
 * 2. 准备数据一定要转成字节数组，
 * 3. 封装成Datagrampacket 包裹，需要制定目的地
 * 4. 发送包裹send(DatagramPacket p)
 * 5. 释放资源
 * @create 2020-05-31 11:30
 */
public class UDPClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送发启动中...");
        // 1. 使用DatagramSocket指定端口，创建接收端
        DatagramSocket client = new DatagramSocket(8888);
        // 2. 准备数据一定要转成字节数组，
        String data = "网络编程课程练习";
        byte[] datas = data.getBytes();
        // 3. 封装成Datagrampacket 包裹，需要制定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",9999));
        // 4. 发送包裹send(DatagramPacket p)
        client.send(packet);
        // 5. 释放资源
        client.close();
    }
}
