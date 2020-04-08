package mypro09.cn.zh.collection;

import java.util.*;

/**
 * @author 张辉
 * @Description 测试collection中的方法
 * @create 2020-04-07 18:13
 */
public class TestList {
    public static void main(String[] args) {
        test03();
    }

    public static void test01() {
        Collection<String> c = new ArrayList<>();
        // Collection的方法在Set和List中都有

        Set s;

        c.size();
        // C容器的大小
        System.out.println(c.size());
        System.out.println(c.isEmpty());
        // C容器是否为空

        c.add("zs");
        // 向C中添加元素
        c.add("as");
        System.out.println(c);
        System.out.println(c.size());

        System.out.println(c.contains("so"));
        // 判断C容器中有没有元素“so”

        Object[] objs = c.toArray();
        // 将容器中数据转换成数组
        System.out.println(objs);
        System.out.println(Arrays.toString(objs));
        // 输出数组中所有的元素的方法


        c.remove("as");
        // 将元素从容器中移除出去，不是删除
        System.out.println(c);
        System.out.println(c.size());

        c.clear();
        System.out.println(c.size());
    }

    public static void test02() {
        List<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");

        System.out.println("list01:" + list01);
        //list01.addAll(list02);
        // 将list02中的所有元素添加到list01中
        //list01.removeAll(list02);
        // 将list01中和list02相同的元素删除掉。
        //list01.retainAll(list02);
        // 将list01和list02中相同的元素放到list01中
        //System.out.println("list01:"+ list01);

        System.out.println(list01.containsAll(list02));
        // 判断list01中是不是全部包括list02中的所有元素
    }

    public static void test03() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        // 在末尾添加元素
        System.out.println(list);

        list.add(2,"wo");
        // 在指定位置添加元素，把之前的位置往后顶。
        System.out.println(list);

        list.remove(2);
        // 删除指定索引的元素
        System.out.println(list);

        list.set(2,"zs");
        // 覆盖之前这个位置的元素。
        System.out.println(list);

        System.out.println(list.get(2));
        // 获取List容器中这个位置的元素。

        list.add("C");
        list.add("B");
        list.add("A");
        System.out.println(list);

        System.out.println(list.indexOf("B"));
        System.out.println(list.lastIndexOf("B"));
        // 关于索引位置的检索
    }
}
