package mypro08.cn.zh.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author 张辉
 * @Description 测试时间对象和字符串之间的相互转化，DateFormat抽象类和SimpleFormat实现类的使用
 * @create 2020-04-07 12:04
 */
public class TestDateFormat {
    public static void main(String[] args) throws ParseException {
        // 把时间对象按照"格式字符串指定的格式"转成相应的字符串
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // SimpleDateFormat是DateFormat的一个子类
        String str = df.format(new Date(40000000));
        System.out.println(str);

        // 把字符串按照“格式字符串指定格式”转成相应的时间对象
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月DD日 hh时mm分ss秒");
        Date date = df2.parse("2020年04月07日 12时16分40秒");
        System.out.println(date);

        // 测试其他的格式字符。比如：利用D，获取本事件对象是所处年份的第几天。
        DateFormat df3 = new SimpleDateFormat("D");
        // SimpleDateFormat是DateFormat的一个子类
        String str3 = df3.format(new Date());
        System.out.println(str3);
    }
}
