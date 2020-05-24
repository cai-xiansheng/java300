package algorithm.Acwing;

import java.util.Scanner;

/**
 * @author 张辉
 * @Description Awing算法
 * @create 2020-05-24 16:03
 */

/**
 * 0-1背包问题（每个物品只可以使用一次）
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 */
public class Main {
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 数据量
        int m = sc.nextInt();// 容量
        int[] v = new int[n];// 第i件的体积
        int[] w = new int[n];// 第i件的价值
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        sc.close();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 0) {
                    if (v[i] <= j) {
                        dp[i][j - 1] = w[i];
                    } else {
                        dp[i][j - 1] = 0;
                    }
                } else {
                    if (v[i] <= j) {
                        int tmp = w[i];
                        int p = j - v[i];
                        if (j - v[i] > 0) {
                            tmp = tmp + dp[i - 1][p - 1];
                        }
                        if (tmp >= dp[i - 1][j - 1]) {
                            dp[i][j - 1] = tmp;
                        } else {
                            dp[i][j - 1] = dp[i - 1][j - 1];
                        }
                    } else {
                        dp[i][j - 1] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        //for (int i = 0; i < n; i++) {
        //    for (int j = 0; j < m; j++) {
        //        System.out.print(dp[i][j] + " ");
        //    }
        //    System.out.println();
        //}
        System.out.println(dp[n - 1][m - 1]);
    }
}


/**
 * a+b的和
 */
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        sc.close();
//        System.out.println(a+b);
//    }
//}
