package mypro11.cn.zh.syn;

/**
 * @author 张辉
 * @Description 线程不安全
 * 线程不安全：出现负数，出现相同的数
 * @create 2020-05-08 23:31
 */
public class UnsafeTest01 {
    public static void main(String[] args) {
        // 一份资源
        UnsafeWeb12306 web = new UnsafeWeb12306();
        // 多个代理
        new Thread(web,"码畜").start();
        new Thread(web,"码农").start();
        new Thread(web,"码蝗").start();

    }
}

class UnsafeWeb12306 implements Runnable{

    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test();
        }
    }

    public void test(){
        if (ticketNums < 0) {
            flag = false;
            return;
        }
        // 模拟延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
    }
}