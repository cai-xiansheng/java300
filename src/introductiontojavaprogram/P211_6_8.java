package introductiontojavaprogram;

/**
 * @author 张辉
 * @Description java作业
 * @create 2020-03-27 12:17
 */
public class P211_6_8 {
    public static void kTOp() {
        double k = 2.2;
        int m = 5;
        System.out.println("Kilograms  Pounds | Pounds  Kilograms");
        for (int i = 1, j = 20; i < 200; i += 2, j += 5) {
            System.out.printf("%9d", i);
            System.out.printf("%8.2f", i * k);
            System.out.print(" |");
            System.out.printf("%7d", j);
            System.out.printf("%8.2f\n", j / k);
        }
    }

    public static void divisible() {
        /* 100-200 */
        int flag;
        for (int i = 100; i <= 200; i++) {
            flag = 0;
            if (i % 5 == 0) {
                flag++;
            }
            if (i % 6 == 0) {
                flag++;
            }
            if (flag == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
//        kTOp();
        divisible();
    }
}
