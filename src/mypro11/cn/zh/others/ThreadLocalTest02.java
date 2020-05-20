package mypro11.cn.zh.others;

import java.util.Set;

/**
 * @author 张辉
 * @Description ThreadLocal
 * 每个线程自身的存储本地、局部区域，更改不会影响其他线程
 * get/set/initialValue
 * @create 2020-05-14 12:35
 */
public class ThreadLocalTest02 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRun()).start();
        }
    }

    public static class MyRun implements Runnable{

        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "得到-->" + left);
            threadLocal.set(left-1);
            System.out.println(Thread.currentThread().getName() + "剩下-->" + threadLocal.get());

        }
    }
}
