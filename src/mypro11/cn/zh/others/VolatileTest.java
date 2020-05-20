package mypro11.cn.zh.others;

/**
 * @author 张辉
 * @Description volatile 用于保证数据得同步，也就是可见性
 * volatile 可以避免指令重排
 * @create 2020-05-14 11:14
 */
public class VolatileTest {
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num == 0) {
                // 此处不要编写代码
            }
        }).start();

        Thread.sleep(1000);
        num = 1;
    }
}
