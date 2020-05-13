package mypro11.cn.zh.syn;

/**
 * @author 张辉
 * @Description 线程安全
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1. 同步方法
 * 2. 同步块
 * @create 2020-05-08 23:31
 */
public class SafeTest01 {
    public static void main(String[] args) {
        // 一份资源
        SafeWeb12306 web = new SafeWeb12306();
        // 多个代理
        new Thread(web,"码畜").start();
        new Thread(web,"码农").start();
        new Thread(web,"码蝗").start();

    }
}

class SafeWeb12306 implements Runnable{

    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test();
        }
    }

    public synchronized void test(){
        // synchronized 线程安全，同步
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
         //模拟延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
    }
}