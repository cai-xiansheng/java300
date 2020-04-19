package mypro10.cn.zh.io;

import java.io.UnsupportedEncodingException;

/**
 * @author 张辉
 * @Description 编码：字符串-->字符集
 * @create 2020-04-19 23:18
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "姓名年龄身份a";

        // 编码：字节数组
        byte[] dates = msg.getBytes();
        // 使用默认工程的字符集
        System.out.println(dates.length);

        // 编码：其他字符集
        dates = msg.getBytes("UTF-16LE");
        System.out.println(dates.length);

        dates = msg.getBytes("GBK");
        System.out.println(dates.length);
    }
}
