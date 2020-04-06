package algorithm;

/**
 * @author 张辉
 * @Description 汉诺塔
 * @create 2020-03-27 11:16
 */
public class Hanoi {

    static void hanoi(int n, char a, char b, char c) {
        // 将n个碟子从a->b;

        // 如果只剩最后一个碟子，也就是n=1时，直接将它移到b即刻；
        if (n == 1) {
            System.out.println("Move dish " + n + " from " + a + " to " + b);
            return;
        }

        // 将n-1个碟子从a->c;
        hanoi(n - 1, a, c, b);
        // 将最后一个碟子，也就是第n个碟子从a->b;
        System.out.println("Move dish " + n + " from " + a + " to " + b);
        // 将n-2个碟子从c->a;
        hanoi(n - 1, c, b, a);
    }

    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }
}
