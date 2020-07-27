package gof23.prototype;

import java.util.Date;

/**
 * @author 张辉
 * @Description 测试原型模式
 * @create 2020-07-26 13:14
 */
public class Client2 {
    public static void main(String[] args) throws Exception {
        Date d = new Date(1231414124124L);
        Sheep2 s1 = new Sheep2("少理", d);
        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());

        Sheep2 s2 = (Sheep2) s1.clone(); // s2的对象是一个新的对象
        s2.setName("多利");
        d.setTime(1541412451510L);

        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
    }
}
