package mypro11.cn.zh.others;

import com.sun.tools.javac.Main;

/**
 * @author 张辉
 * @Description 可重入锁：锁可以延续使用(给子元素可以用)
 * @create 2020-05-14 13:00
 */
public class LockTest {
    public static void main(String[] args) {
        new LockTest().test();
    }
    public void test(){
        // 第一次获得锁
        synchronized (this) {
            while (true) {
                // 第二次获得锁
                synchronized (this) {
                    System.out.println("ReentrantLock!");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
