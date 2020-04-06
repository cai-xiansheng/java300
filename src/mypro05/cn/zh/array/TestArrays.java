package mypro05.cn.zh.array;

import java.util.Arrays;

/**
 * @author 张辉
 * @Description 测试 java.util.Arrays 工具类的使用
 * @create 2020-04-06 18:17
 */
public class TestArrays {
    public static void main(String[] args) {
        int[] a = {10,20,30,0,2};
        System.out.println(a);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.binarySearch(a,-30));
    }
}
