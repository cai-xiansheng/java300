package mypro11.cn.zh.others;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 张辉
 * @Description 不可重入锁：锁可以延续使用(给子元素可以用)
 * @create 2020-05-14 13:00
 */
public class LockTest04 {
    ReentrantLock lock = new ReentrantLock();

    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println(lock.getHoldCount());

    }

    // 不可重入
    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());

        //........
        lock.unlock();
        System.out.println(lock.getHoldCount());


    }

    public static void main(String[] args) throws InterruptedException {
        LockTest04 test02 = new LockTest04();
        test02.a();

        Thread.sleep(1000);
        System.out.println(test02.lock.getHoldCount());
    }

}

