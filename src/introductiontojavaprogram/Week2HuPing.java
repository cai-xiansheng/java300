package introductiontojavaprogram;

/**
 * @author 张辉
 * @Description week2互评作业
 * @create 2020-04-05 19:40
 */
public class Week2HuPing {
    public static void main(String[] args) {
        System.out.println("3,5,6 的结果:" + week(3, 5, 6));
        System.out.println("6,69,180 的结果:" + week(6, 69, 180));
        week1();
    }

    /**
     * 验证等式是否成立
     */
    static boolean week(int a, int b, int c) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += Math.pow(i, 3);
        }
        if (sum != Math.pow(c, 3)) {
            return false;
        }
        return true;
    }

    /**
     * 求多组等式
     * 由于使用了int型变量，就将数据的范围控制在1000以内
     * i表示开始的数字
     * j表示结束的数字
     * k表示结果
     */
    static void week1() {
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1 + i; j <= 1000; j++) {
                for (int k = j; k <= 1000; k++) {
                    if (week(i, j, k) == true) {
                        System.out.println("" + i + "," + j + "," + k + " 的结果: true");
                    }
                }
            }
        }
    }
}
