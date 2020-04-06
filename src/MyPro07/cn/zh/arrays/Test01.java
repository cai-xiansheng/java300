package MyPro07.cn.zh.arrays;

import java.text.Format;

/**
 * @author 张辉
 * @Description 数组
 * @create 2020-04-04 23:43
 */
public class Test01 {
    public static void main(String[] args) {
        // 声明数组
        int[] arr01;
        String[] arr02;
        // 分配空间
        arr01 = new int[10];

        // 声明和分配空间在一块儿
        int[] arr04 = new int[10];

        int a = arr01.length;

        User[] arr03 = new User[3];
        arr03[0] = new User(1001,"张辉");
        arr03[1] = new User(1002,"张辉");
        arr03[2] = new User(1003,"张辉");

        for (int i = 0; i < arr03.length; i++) {
            System.out.println(arr03[i].getId());
        }
    }
}
