package mypro11.cn.zh.thread;

/**
 * @author 张辉
 * @Description 共享资源，并发
 * @create 2020-05-08 8:49
 */
public class Web12306 implements Runnable {
    /**
     * 票数
     */
    private int ticketNums = 99;
    @Override
    public void run() {
        while (true) {
            if (ticketNums < 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }

    public static void main(String[] args) {
        // 一份资源
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        // 多个代理
        new Thread(web,"码畜").start();
        new Thread(web,"码农").start();
        new Thread(web,"码蝗").start();
    }
}
