package mypro09.cn.zh.collection;

import java.util.*;

/**
 * @author 张辉
 * @Description 测试迭代器遍历List, Set, Map
 * @create 2020-04-19 11:45
 */
public class TestIterator {
    public static void main(String[] args) {
        //testIteratorList();
        //testIteratorSet();
        testIteratorMap();
    }

    public static void testIteratorList() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");

        // 使用迭代器遍历List
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    public static void testIteratorSet() {
        Set<String> set = new HashSet<>();

        set.add("aa");
        set.add("bb");
        set.add("cc");

        // 使用迭代器遍历Set
        for (Iterator<String> iter = set.iterator(); iter.hasNext(); ) {
            String temp = iter.next();
            System.out.println(temp);
        }
    }


    public static void testIteratorMap() {
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(100,"aa");
        map1.put(101,"bb");
        map1.put(102,"cc");

        // 第一中遍历Map的方式
        Set<Map.Entry<Integer,String>> ss =  map1.entrySet();

        for (Iterator<Map.Entry<Integer,String>> iter=ss.iterator();iter.hasNext();) {
            Map.Entry<Integer,String> temp = iter.next();

            System.out.println(temp.getKey() + "---" + temp.getValue());
        }

        // 第二种遍历Map的方式
        Set<Integer> keySet = map1.keySet();
        for (Iterator<Integer> iter = keySet.iterator();iter.hasNext();) {
            Integer key = iter.next();
            System.out.println(key + "----" + map1.get(key));
        }
    }
}
