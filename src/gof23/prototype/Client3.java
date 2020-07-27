package gof23.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author 张辉
 * @Description 测试原型模式（深复制，使用序列化和反序列化的方式实现深复制）
 * @create 2020-07-26 13:14
 */
public class Client3 {
    public static void main(String[] args) throws Exception {
        Date d = new Date(1231414124124L);
        Sheep s1 = new Sheep("少理", d);
        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());

        // Sheep s2 = (Sheep) s1.clone(); // s2的对象是一个新的对象
        // 使用序列化和反序列化实现深复制
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();


        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep s2 = (Sheep) ois.readObject();


        System.out.println("修改原型对象的属性值");
        d.setTime(1541412451510L);
        System.out.println(s1.getBirthday());
        s2.setName("多利");




        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
    }
}
