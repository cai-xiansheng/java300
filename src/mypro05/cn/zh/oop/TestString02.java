package mypro05.cn.zh.oop;

/**
 * @author 张辉
 * @Description String方法测试
 * @create 2020-04-06 17:00
 */
public class TestString02 {
    public static void main(String[] args) {
        String s1 = "core java";
        String s2 = "Core java";
        System.out.println(s1.charAt(3));

        System.out.println(s2.length());

        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        System.out.println(s1.indexOf("java"));
        System.out.println(s1.indexOf("app"));

        System.out.println("result is:" + s1.replace(' ','&'));

        /**
         * charAt()     找到字符串指定位置的索引
         * length()     字符串的长度
         * equals()     比较两个字符串是否相同
         * equalsIgnoreCase()       值比较字母，不管大小写
         * indexOf()    找到字符串出现的位置，如果没有找到返回-1.
         * replace()    找到对应的字符并且替换掉
         * startsWith() 判断字符串的开头是不是我们给的字符串
         * endWith()    判断字符串的结尾是不是我们给的字符串
         * substring()  截取字符串，一个参数是从当前位置开始截取，两个参数是截取索引范围内的串。
         * trim()       去除字符串首尾的空格
         */

        String s = "";
        String s3 = "how are you?";

        System.out.println(s3.startsWith("how"));
        System.out.println(s3.endsWith("you"));

        s = s3.substring(4);
        System.out.println(s);
        s = s3.substring(4,7);
        System.out.println(s);

        s = s1.toLowerCase();
        System.out.println(s);
        s= s1.toUpperCase();
        System.out.println(s);
        String s4 = "how old are you!! ";
        s = s4.trim();
        System.out.println(s + "adg");
        System.out.println(s4 + "sadg");
    }
}
