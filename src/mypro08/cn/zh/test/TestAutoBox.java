package mypro08.cn.zh.test;

/**
 * @author 张辉
 * @Description 测试自动装箱、自动拆箱
 * @create 2020-04-07 0:06
 */
public class TestAutoBox {
    public static void main(String[] args) {
        Integer a = 24;
        // Integer a = Integer.valueOf(24);

        int b = a;
        // int b = a.intValue();

        Integer c = null;
        if (c != null) {
            int d = c;
        }
        // 拆箱，自动调用c.intValue()

        // 缓存[-128,127]之间的数字，实际就是系统初始化的时候，创建了一个[-128,127]之间的一个缓存数组
        // 当我们调用valueOf()的时候，首先检查是否在[-128,127]之间，如果在这个范围则直接从缓存数组中拿出来已经缓存的数
        // 如果不在这个范围内，则创建新的Integer对象
        Integer in1 = Integer.valueOf(-128);
        Integer in2 = -128;
        System.out.println(in1 == in2);
        //true 因为123在缓存范围内
        System.out.println(in1.equals(in2));
        //true
        Integer in3 = 1234;
        Integer in4 = 1234;
        System.out.println(in3 == in4);
        //false 因为1234不在缓存范围内
        System.out.println(in3.equals(in4));
        //true
    }
}
