package algorithm;

import javax.lang.model.type.ArrayType;

/**
 * @author 张辉
 * @Description （10）利用分治法求一组数据的和
 * @create 2020-03-27 10:54
 */
public class Sum {
    static int sum(int[] array, int a, int b) {
        if (b - a < 2) {
            int res = 0;
            for (int i = a; i <= b; i++) {
                res += array[i];
            }
            return res;
        } else {
            int res = 0;
            int flag = (a + b) / 2;
            res += sum(array, a, flag);
            res += sum(array, flag + 1, b);
            return res;
        }

    }

    public static void main(String[] args) {
        int[] array = {1,9,2,0,4,5,6,7,10,14};
        int res = 0;
        res += sum(array,0,9);
        System.out.println(res);
    }
}
