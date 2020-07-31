package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-31 0:21
 */
public class Demo01 {
    public static void main(String[] args) {
        // 表达式对象
        Pattern p = Pattern.compile("\\w+");

        // 创建Matcher对象
        Matcher m = p.matcher("afdagas&&589018450");

        boolean  yes = m.matches(); // 尝试将整个字符序列与改模式匹配

        boolean e = m.find(); // 该方法扫描输入的序列，查找与该模式匹配的下一个子序列
        System.out.println(m.group()); // 返回匹配到的内容

        System.out.println(yes);
    }
}
