package mypro05.cn.zh.array;

import java.util.Arrays;

/**
 * @author 张辉
 * @Description 测试冒泡排序
 * @create 2020-04-06 23:32
 */
public class TestBubbleSort {
    public static void main(String[] args) {
        int[] values = {3, 1, 6, 7, 0, 9, 4, 5, 8};
        int temp = 0;

        for (int j = 0; j < values.length - 1; j++) {
            boolean flag = true;
            for (int i = 0; i < values.length - j - 1; i++) {
                // 比较大小，换顺序
                if (values[i] > values[i + 1]) {
                    temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;

                    flag = false;
                }
                System.out.println(Arrays.toString(values));
            }
            if (flag) {
                break;
            }
            System.out.println("###########");
        }
    }
}
