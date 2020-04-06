package mypro05.cn.zh.array;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 张辉
 * @Description 测试二分法查找（折半查找）
 * @create 2020-04-06 23:44
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 2, 9, 0, 7, 4, 5, 8};
        Arrays.sort(arr);

        int value = 7;

        System.out.println(BinarySearch(arr,value));
    }

    public static int BinarySearch(int[] arr, int value) {
        int low = 0;
        int height = arr.length - 1;

        while (low <= height) {
            int mid = (low + height) / 2;
            if (value == arr[mid]) {
                return mid;
            }

            if (value > arr[mid]) {
                low = mid + 1;
            }

            if (value < arr[mid]) {
                height = mid-1;
            }
        }

        return -1;
    }
}
