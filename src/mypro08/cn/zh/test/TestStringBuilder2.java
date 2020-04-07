package mypro08.cn.zh.test;

/**
 * @author 张辉
 * @Description 测试StringBuilder,StringBuffer 可变字符序列
 * @create 2020-04-07 11:19
 */
public class TestStringBuilder2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            char temp = (char)('a'+ i);
            sb.append(temp);
            // 插入
        }
        System.out.println(sb);

        sb.reverse();
        // 反转
        System.out.println(sb);

        sb.setCharAt(3,'张');
        // 替换
        System.out.println(sb);

        sb.insert(0,'我').insert(6,'哎');
        // 插入，insert链式调用，核心方法就是，该方法将自己返回了，return this
        System.out.println(sb);

        sb.delete(20,23);
        // 删除
        System.out.println(sb);

    }
}
