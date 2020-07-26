package gof23.prototype;

import java.util.Date;

/**
 * @author 张辉
 * @Description 测试原型模式
 * @create 2020-07-26 13:14
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Date d = new Date(1231414124124L);
        Sheep s1 = new Sheep("少理", d);
        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());

        Sheep s2 = (Sheep) s1.clone();
        s2.setName("多利");
        d.setTime(1541412451510L);
        System.out.println(s1.getBirthday());

        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
    }
}
