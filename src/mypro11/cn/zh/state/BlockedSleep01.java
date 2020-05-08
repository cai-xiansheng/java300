package mypro11.cn.zh.state;


/**
 * @author 张辉
 * @Description sleep模拟网络延时，放大了发生问题的可能性
 * 1. sleep(时间)指定当前线程阻塞的毫秒数
 * 2. sleep存在异常InterruptedException
 * 3. sleep时间达到后线程进入就绪状态
 * 4. sleep可以模拟网络延时、倒计时等。
 * 5. 每个对象都有一个锁，sleep不会释放锁（抱着CPU睡觉）
 * @create 2020-05-08 14:36
 */
public class BlockedSleep01 {
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

class Web12306 implements Runnable {
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
            // 模拟网络延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }
}

