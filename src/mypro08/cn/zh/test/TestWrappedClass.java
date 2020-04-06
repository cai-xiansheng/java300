package mypro08.cn.zh.test;

/**
 * @author 张辉
 * @Description 测试包装类
 * @create 2020-04-06 23:56
 */
public class TestWrappedClass {
    public static void main(String[] args) {
        // 基本数据类型转成包装类对象
        Integer a = new Integer(3);
        Integer b = Integer.valueOf(30);

        // 把包装类对象转成解百纳数据类型
        int c = b.intValue();
        double d = b.doubleValue();

        // 把字符串转成包装类对象
        Integer e = new Integer("999");
        Integer f = Integer.parseInt("9999888");

        // 把包装类对象转为字符串
        String str = f.toString();

        // 常见的常量
        System.out.println("int类型最大的整数：" + Integer.MAX_VALUE);

    }
}
