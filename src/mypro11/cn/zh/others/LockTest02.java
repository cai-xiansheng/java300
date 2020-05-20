package mypro11.cn.zh.others;

import java.security.PublicKey;

/**
 * @author 张辉
 * @Description 不可重入锁：锁可不以延续使用(给子元素可以用)
 * @create 2020-05-14 13:00
 */
public class LockTest02 {
    Lock lock = new Lock();
    public void a() throws InterruptedException {
        lock.lock();
        doSomething();
        lock.unlock();
    }
    // 不可重入
    public void doSomething() throws InterruptedException {
        lock.lock();
        //........
        lock.unlock();

    }
    public static void main(String[] args) throws InterruptedException {
        LockTest02 test02 = new LockTest02();
        test02.a();
        test02.doSomething();
    }

}

// 不可重入锁
class Lock {
    // 是否占用
    private boolean isLocked = false;

    // 使用锁
    public synchronized void lock() throws InterruptedException {
        while (isLocked){
            wait();
        }
        isLocked =true;
    }

    // 释放锁
    public void unlock() {
        isLocked = false;
        notify();
    }
}
