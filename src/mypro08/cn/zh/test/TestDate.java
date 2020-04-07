package mypro08.cn.zh.test;

import java.util.Date;

/**
 * @author 张辉
 * @Description 测试Date类的常见方法
 * @create 2020-04-07 11:52
 */
public class TestDate {
    public static void main(String[] args) {
        Date d = new Date(2000);
        System.out.println(d);
        // 这个时间还受时区影响

        System.out.println(d.getTime());

        Date d2 = new Date();
        System.out.println(d2.getTime());

        System.out.println(d2.after(d));

        // 以后遇到处理日期，使用Calendar
        Date d3 = new Date(2020-1900,4-1,7);
        System.out.println(d3);
    }
}
