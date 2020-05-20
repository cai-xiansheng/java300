package mypro11.cn.zh.others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 张辉
 * @Description CAS :比较并交换
 * @create 2020-05-14 13:38
 */
public class CAS {
    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();
                if (left <1) {
                    System.out.println("抢完了！。。。");
                    return;
                }
                System.out.println(Thread.currentThread().getName()+ "抢了一件商品");
                System.out.println("-->还剩" + left);
            }).start();
        }
    }
}
