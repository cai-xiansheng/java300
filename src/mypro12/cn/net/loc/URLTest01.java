package mypro12.cn.net.loc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 张辉
 * @Description URL :统一资源定位器，互联网的三大基石之一（URL，HTTP，HTML），区分定位资源。
 * 1. 协议
 * 2. 域名、计算机
 * 3. 端口：默认80（也就是不写的时候）
 * 4. 请求资源
 * http://www.baidu.com:80/index?uname=shsxt&age=18#a
 *
 * URL方法
 * 获取网络协议：getProtocol();
 * 获取域名或者IP：getHost();
 * 获取请求的资源（包括请求的参数）：getFile();
 * 获取请求的资源：getPath();
 * 获取请求的端口：getPort();
 * 获取请求的参数：getQuery();
 * @create 2020-05-31 10:42
 * 获取锚点：getRef();
 */
public class URLTest01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index?uname=shsxt&age=18#acs");
        // 获取四个值
        System.out.println("协议：" + url.getProtocol());
        System.out.println("域名|ip：" + url.getHost());
        System.out.println("请求资源1：" + url.getFile());
        System.out.println("请求资源2：" + url.getPath());
        System.out.println("请求端口：" + url.getPort());

        // 参数
        System.out.println("参数：" + url.getQuery());

        // 锚点
        System.out.println("锚点：" + url.getRef());
    }
}
