package mypro08.cn.zh.test;

/**
 * @author 张辉
 * @Description 测试StringBuilder 可变字符序列
 * @create 2020-04-07 0:24
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        String str;

        // StringBuilder线程不安全，效率该（*一般不使用它）；StringBuffer线程安全，效率低。
        StringBuilder sb = new StringBuilder("abcdefgh");

        // 打印地址
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

        sb.setCharAt(2,'M');
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);


    }
}
