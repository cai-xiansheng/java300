package mypro10.cn.zh.io;

/**
 * @author 张辉
 * @Description 递归
 * @create 2020-04-19 22:22
 */
public class DirDemo03 {
    public static void main(String[] args) {
        printTen(1);
    }
    /**
     * 打印1-10的数
      */
    public static void printTen(int n) {
        if (n>10) {
            return;
            // 递归头：结束递归
        }
        System.out.println(n);
        // 递归体：自己调自己
        printTen(n+1);
    }
}
