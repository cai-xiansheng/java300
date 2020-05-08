package mypro11.cn.zh.state;

/**
 * @author 张辉
 * @Description Yield 礼让线程，暂停线程，直接进入就绪状态，不是阻塞状态（睡觉时交出CPU）
 * @create 2020-05-08 16:18
 */
public class YieldDemo02 {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("lambda..." + i);
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            if (i % 20 == 0) {
                Thread.yield();
                // mian 礼让 （写在那个里面哪个礼让）
            }
            System.out.println("main" + i);
        }
    }
}

