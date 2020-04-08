package mypro09.cn.zh.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张辉
 * @Description 测试 HashMap 的使用
 * @create 2020-04-08 16:41
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> m1 = new HashMap<>();
        m1.put(1,"one");
        m1.put(2,"two");
        m1.put(3,"three");

        System.out.println(m1.get(1));
        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.containsKey(1));
        System.out.println(m1.containsValue("four"));

        Map<Integer,String> m2 = new HashMap<>();
        m2.put(4,"四");
        m2.put(5,"五");

        m1.putAll(m2);
        System.out.println(m1);
        // map中的键不能重复，如果重复（是根据equals方法来判断），则新的覆盖旧的！
        m1.put(3,"三");
        System.out.println(m1);
    }
}
