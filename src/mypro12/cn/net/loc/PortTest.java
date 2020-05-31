package mypro12.cn.net.loc;

import java.net.InetSocketAddress;

/**
 * @author 张辉
 * @Description 端口
 * 1. 区分软件
 * 2. 2个字节 0-65535 UDP TCP
 * 3. 同一个协议端口不能冲突
 * 4. 定义端口越大越好
 * InetSocketAddress (Socket就是有端口的)
 * 1. 构造器
 * new InetSocketAddress(地址|域名,端口);
 * 2. 方法
 * getAddress();
 * getPort();
 * getHostName();
 *
 * @create 2020-05-31 10:30
 */
public class PortTest {
    public static void main(String[] args) {
        // 包含端口
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",3306);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost",4000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress1.getAddress());
        System.out.println(socketAddress1.getPort());
    }
}
