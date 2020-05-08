package mypro11.cn.zh.state;

/**
 * @author 张辉
 * @Description join：合并线程，插队线程
 * @create 2020-05-08 16:28
 */
public class BlockedJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda..." + i);
            }
        });
        t.start();

        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                t.join();
                // 插队，main线程被阻塞
            }
            System.out.println("main..." + i);
        }
    }
}
