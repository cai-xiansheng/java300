package MyPro02;

import java.util.Scanner;

/**
 * @author 张辉
 * @Description Scanner类的使用
 * @create 2020-03-24 18:13
 */
public class TestScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(n);
    }
}
