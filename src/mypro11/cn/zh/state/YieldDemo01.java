package mypro11.cn.zh.state;

/**
 * @author 张辉
 * @Description Yield 礼让线程，暂停线程，直接进入就绪状态，不是阻塞状态（睡觉时交出CPU）
 * @create 2020-05-08 16:18
 */
public class YieldDemo01 {
    public static void main(String[] args) {
        MyYield my = new MyYield();
        new Thread(my,"a").start();
        new Thread(my,"b").start();
    }
}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->start");
        Thread.yield();
        // 礼让
        System.out.println(Thread.currentThread().getName()+"--->end");
    }
}
