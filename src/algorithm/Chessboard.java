package algorithm;

import java.util.Arrays;

/**
 * @author 张辉
 * @Description 残缺棋盘的问题
 * @create 2020-04-14 22:38
 */
public class Chessboard {
    static int number = 0;
    static int[][] arr = new int[100][100];

    public static void main(String[] args) {
        int s = 4;
        int x = 0;
        int y = 0;
        arr[x][y] = 0;
        cover( 0, 0, s, x, y);
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.printf("%2d ",arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void cover( int w, int h, int n, int x, int y) {
        // w,h为顶角做坐标，x,y为残缺位置
        if (n < 2) {
            return;
        }
        int s = n / 2;
        number++;
        if (x <h+ s && y < w+s) {
            // 左上
            arr[h + s - 1][w + s] = number;
            arr[h + s][w + s] = number;
            arr[h + s][w + s - 1] = number;

            cover( w, h, s, x, y);
            cover( w + s, h, s, x + s - 1, y + s);
            cover(w, h + s, s, x + s, y + s - 1);
            cover( w + s, h + s, s, x + s, y + s);

        } else if (x < h+ s && y >= w+s) {
            // 右上
            arr[h + s - 1][w + s - 1] = number;
            arr[h + s][w + s] = number;
            arr[h + s][w + s - 1] = number;

            cover( w, h, s, x + s - 1, y + s - 1);
            cover( w + s, h, s, x, y);
            cover( w, h + s, s, x + s, y + s - 1);
            cover( w + s, h + s, s, x + s, y + s);

        } else if (x >= h+ s && y < w+s) {
            // 左下
            arr[h + s - 1][w + s] = number;
            arr[h + s][w + s] = number;
            arr[h + s - 1][w + s - 1] = number;

            cover( w, h, s, x + s - 1, y + s - 1);
            cover(w + s, h, s, x + s - 1, y + s);
            cover( w, h + s, s, x, y);
            cover( w + s, h + s, s, x + s, y + s);

        } else if (x >= h+ s && y >= w+s) {
            // 右下
            arr[h + s - 1][w + s] = number;
            arr[h + s - 1][w + s - 1] = number;
            arr[h + s][w + s - 1] = number;

            cover( w, h, s, x + s - 1, y + s - 1);
            cover( w + s, h, s, x + s - 1, y + s);
            cover( w, h + s, s, x + s, y + s - 1);
            cover( w + s, h + s, s, x, y);

        }
    }
}
