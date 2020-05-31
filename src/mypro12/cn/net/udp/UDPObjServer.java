package mypro12.cn.net.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;


/**
 * @author 张辉
 * @Description 引用类型 UDP接收端
 *
 * DatagramSocket:用于发送或接受数据包的套接字
 * DatagramPacket:数据包
 *
 *
 * Address already in use: Cannot bind 同一个协议下，端口不允许重复
 * 1. 使用DatagramSocket指定端口，创建接收端
 * 2. 准备容器，封装成Datagrampacket 包裹
 * 3. 阻塞式接收包裹receive(DatagramPacket p)
 * 4. 分析数据 将字节数组还原成为对应的类型
 * byte[] getData();
 * getLength()
 * 5. 释放资源
 * @create 2020-05-31 11:30
 */
public class UDPObjServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中...");
        // 1. 使用DatagramSocket指定端口，创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        // 2. 准备容器，封装成Datagrampacket 包裹
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        // 3. 阻塞式接收包裹receive(DatagramPacket p)
        server.receive(packet);
        // 4. 分析数据 将字节数组还原成为对应的类型
        //  byte[] getData();
        //          getLength()
        byte[] datas = packet.getData();
        int len = packet.getLength();

        ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream(datas)));
        // 顺序与写出一致
        String msg = ois.readUTF();
        int age = ois.readInt();
        boolean flag = ois.readBoolean();
        char ch = ois.readChar();
        Object str = ois.readObject();
        Object date = ois.readObject();
        Object employee = ois.readObject();
        ois.close();

        if (str instanceof String) {
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if (date instanceof Date) {
            Date dataObj = (Date)date;
            System.out.println(dataObj);
        }
        if (employee instanceof Employee) {
            Employee empObj = (Employee)employee;
            System.out.println(empObj.getName() + "-->" + empObj.getSalary());
        }


        System.out.println(msg + "--" + age);

        // 5. 释放资源
        server.close();
    }
}
