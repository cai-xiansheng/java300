package mypro12.cn.net.loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 张辉
 * @Description IP 定位一个节点：计算机、路由、通讯设备
 * InetAddress: 多个静态方法
 * 1. getLocalHost(): 获取本机
 * 2. getByName(): 根据域名DNS --》 IP地址
 *
 * 两个成员方法：
 * 1. getHostAddress: 返回地址
 * 2. getHostName: 返回计算机名
 * @create 2020-05-31 9:22
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        // 使用getLocalHost方法创建InetAddress本机对象
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress()); // 返回：192.168.1.149
        System.out.println(addr.getHostName()); // 返回：计算机名

        // 根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.ali.com");
        System.out.println(addr.getHostAddress()); // 返回baidu服务器的ip：36.152.44.95
        System.out.println(addr.getHostName()); // 输出：www.baidu.com

        // 根据ip得到inetAddress对象
        addr = InetAddress.getByName("36.152.44.95");
        System.out.println(addr.getHostAddress()); // 返回ip:36.152.44.95
        System.out.println(addr.getHostName()); //输出ip而不是域名。如果这个IP地址不存在或者DNS服务器不允许进行IP地址和域名的映射，getHostName()方法就直接返回IP地址

    }
}
