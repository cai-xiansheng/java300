package mypro09.cn.zh.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 张辉
 * @Description Collections 辅助类的使用 （Collection是接口，Collections是工具类）
 * @create 2020-04-19 12:21
 */
public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("zs" + i);
        }
        System.out.println(list);

        Collections.shuffle(list);
        // 随机排列list中元素
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);


        Collections.sort(list);
        // 按照递增的方式排序。自定义的类的使用：Comparable接口。
        System.out.println(list);

        System.out.println(Collections.binarySearch(list, "zs1"));
        // 二分查找法
    }
}
