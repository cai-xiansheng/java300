package introductiontojavaprogram;

import java.util.Scanner;

/**
 * @author 张辉
 * @Description
 * @create 2020-04-19 14:27
 */
public class LanQiao {
    public static void main(String[] args) {
        s5();
    }

    public static void s5() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        sc.close();
        int[] temp = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i][2] < arr[j][2]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                double len = Math.sqrt(Math.pow(Math.abs(arr[i][1] -arr[j][1]),2) + Math.pow(Math.abs(arr[i][0] -arr[j][0]),2));
                if (arr[i][2]+arr[j][2] > len) {
                    System.arraycopy(arr,j+1,arr,j,arr.length-j-1);
                    n--;
                }
            }
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow((arr[i][2]),2);
        }
        System.out.println((int)sum);


    }


    static int flags = 0;

    public static void s4() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        int[] arr = new int[m];
        for (int i = 2; i <= n; i++) {
            arr[0] = i;
            s41(arr, 1, m, n);
        }
        System.out.println(flags % 10000);
    }

    public static void s41(int[] arr, int number, int m, int n) {
        if (number == m) {
            //System.out.println(Arrays.toString(arr));
            flags++;
            return;
        }
        if ((number + 1) % 2 == 0) {
            // 偶数位
            for (int i = 1; i <= n; i++) {
                if (i < arr[number - 1]) {
                    arr[number] = i;
                    s41(arr, number + 1, m, n);
                }
            }
        } else {
            // 奇数位
            for (int i = 1; i <= n; i++) {
                if (i > arr[number - 1]) {
                    arr[number] = i;
                    s41(arr, number + 1, m, n);
                }
            }
        }
    }

    public static void s3() {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        System.out.println(s31(w, h, x, y)
        );
    }

    public static int s31(int w, int h, int x, int y) {
        int number = 1;
        int top = 0;
        int bottom = h;
        int left = 0;
        int right = w;
        int[][] arr = new int[w][h];

        while (number < w * h) {
            for (int i = left; i <= right; i++) {
                if (top == x - 1 && i == y - 1) {
                    return number;
                }
                arr[top][i] = number++;
            }
            top++;

            for (int i = top; i < bottom - 1; i++) {
                if (i == x - 1 && right == y - 1) {
                    return number;
                }
                arr[i][right] = number++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                if (bottom - 2 == x - 1 && i == y - 1) {
                    return number;
                }
                arr[bottom - 2][i] = number++;
            }
            bottom--;

            for (int i = bottom - 2; i >= top; i--) {
                if (i == x - 1 && left == y - 1) {
                    return number;
                }
                arr[i][left] = number++;
            }
            left++;
        }


        return 1;
    }

    public static void s2() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        StringBuilder strs = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            strs.append((char) (str.charAt(i) + 3));
        }
        System.out.println(strs.toString());

    }

    public static void s1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        int number = 0;
        for (int i = 1; i <= n; i++) {
            if (i % a != 0 && i % b != 0 && i % c != 0) {
                number++;
            }
        }
        System.out.println(number);
    }

}
