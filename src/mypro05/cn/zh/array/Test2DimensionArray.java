package mypro05.cn.zh.array;

import java.util.Arrays;

/**
 * @author 张辉
 * @Description 测试二维数组
 * @create 2020-04-06 18:24
 */
public class Test2DimensionArray {
    public static void main(String[] args) {
//        int[] a = new int[3];

//        Car[] cars = new Car[3];
        int[][] a = new int[3][];

        a[0] = new int[]{10, 20};
        a[1] = new int[]{10, 15, 20};
        a[2] = new int[]{2, 3, 0};

        System.out.println(a[1][2]);

        // 静态初始化二维数组
        int[][] b = { { 1, 2, 3 }, { 3, 4 }, { 3, 5, 6, 7 } };
        System.out.println(Arrays.toString(b[1]));
    }
}


class Car {

}