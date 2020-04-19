package mypro10.cn.zh.io;

import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;

/**
 * @author 张辉
 * @Description 解码：--> 字符串
 * @create 2020-04-19 23:24
 */
public class ContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "姓名年龄身份a";

        // 编码：字节数组
        byte[] dates = msg.getBytes();

        // 解码：字符串 String(byte[] bytes,int offset,int length,String charsetName)
        msg = new String(dates,0,dates.length,"utf8");
        System.out.println(msg);

        // 乱码：
        // 1. 字节数不够
        msg = new String(dates,0, dates.length -2,"utf8");
        System.out.println(msg);
        msg = new String(dates,0, dates.length -1,"utf8");
        System.out.println(msg);

        // 2. 字符集不统一
        msg = new String(dates,0, dates.length -2,"GBK");
        System.out.println(msg);
    }
}
