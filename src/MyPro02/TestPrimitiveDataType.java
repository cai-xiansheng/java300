package MyPro02;


/**
 * @author 张辉
 * @Description 测试基本的数据类型
 * @create 2020-03-20 21:49
 */
public class TestPrimitiveDataType {
    public static void main(String[] args) {
        // 测试整型变量
        int a = 15;
        int b = 015; // 0开头是八进制
        int c = 0x15; // 0x开头是16进制
        int d = 0b1101; // 0b开头是二进制
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        // 整形常量默认为int类型
        byte e = 30;
        long globalPopulation = 74000000000L;
        // 后面加L的就是长整型，长整型在使用的时候必须加L/l


        float p = 3.14f;
        // 4个字节,float 型必须带f
        // 浮点数不精确，不要比较
        double o = 3.14;
        double i = 314E-2;
        // 8个字节 ，double




        // 大数使用
        /*
        *BigDecimal ,大数的浮点使用，没有误差，float会产生误差
        *BigInteger ,大数的整形
         */

    }
}
