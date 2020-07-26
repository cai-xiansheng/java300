package gof23.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-26 8:36
 */
public class Client2 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int threadNum = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int j = 0; j < threadNum; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        Object o = LockSingleton.getInstance();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await(); // main线程阻塞，直到计数器变为0，才会继续往下执行

        // 可以在这儿一直检测线程有没有执行完，也就是监测线程是否存活

        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));

    }
}
