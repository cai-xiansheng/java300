package mypro12.cn.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * @author 张辉
 * @Description UDP接收端
 *
 * DatagramSocket:用于发送或接受数据包的套接字
 * DatagramPacket:数据包
 *
 *
 * Address already in use: Cannot bind 同一个协议下，端口不允许重复
 * 1. 使用DatagramSocket指定端口，创建接收端
 * 2. 准备容器，封装成Datagrampacket 包裹
 * 3. 阻塞式接收包裹receive(DatagramPacket p)
 * 4. 分析数据
 * byte[] getData();
 * getLength()
 * 5. 释放资源
 * @create 2020-05-31 11:30
 */
public class UDPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中...");
        // 1. 使用DatagramSocket指定端口，创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        // 2. 准备容器，封装成Datagrampacket 包裹
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        // 3. 阻塞式接收包裹receive(DatagramPacket p)
        server.receive(packet);
        // 4. 分析数据
        //  byte[] getData();
        //          getLength()
        byte[] datas = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(datas, 0, len));
        // 5. 释放资源
        server.close();
    }
}
