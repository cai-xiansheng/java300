package MyPro07.cn.zh.arrays;

/**
 * @author 张辉
 * @Description foreach
 * @create 2020-04-05 0:14
 */
public class Test03 {
    public static void main(String[] args) {
        int[] a = new int[4];
        // for循环可以初始化，读取数组的值
        for (int i = 0; i < 4; i++) {
            a[i] = i * 10;
        }


//        foreach 循环用于读取数组元素的值，不能修改元素的值
        for (int m : a) {
            System.out.println(m);
        }

        String[] ss = { "aa", "bbb", "ccc", "ddd" };
        for (String temp : ss) {
            System.out.println(temp);
        }
    }
}
