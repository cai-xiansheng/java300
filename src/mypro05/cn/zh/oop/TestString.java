package mypro05.cn.zh.oop;

/**
 * @author 张辉
 * @Description 测试字符串类的基本用法
 * @create 2020-04-06 16:43
 */
public class TestString {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = new String("def");
        String str3 = "abc" + "ags";
        String str4 = "18" + 19;
        /**
         * 不是加法，是字符串连接符
         * String被放在常量池中
         */

        System.out.println("######");
        String str10 = "zs";
        String str11 = "zs";
        String str12 = new String("zs");

        System.out.println(str10 == str11);
        System.out.println(str12 == str11);

        /**str1和str12不是同一个对象
         * 普遍比较字符串时，使用equals*/

        System.out.println(str11.equals(str12));

    }
}
