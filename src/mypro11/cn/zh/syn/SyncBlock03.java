package mypro11.cn.zh.syn;

/**
 * @author 张辉
 * @Description synchronized
 * synchronized 锁的对象的地址不能变
 * @create 2020-05-13 17:35
 */
public class SyncBlock03 {
    public static void main(String[] args) {
        // 一份资源
        SyncWeb12306 web = new SyncWeb12306();
        // 多个代理
        new Thread(web, "码畜").start();
        new Thread(web, "码农").start();
        new Thread(web, "码蝗").start();

    }
}

class SyncWeb12306 implements Runnable {

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
            test5();
        }
    }

    public synchronized void test1() {
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

    public void test2() {
        // synchronized 线程安全，同步
        synchronized (this) {
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

    public void test3() {
        // 锁定失败，ticketNums 对象在变
        synchronized ((Integer) ticketNums) {
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


    public void test4() {
        // 锁定失败，范围太小，锁不住
        synchronized (this) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
        }
        //模拟延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);


    }

    public void test5() {
        // 尽可能锁定合理的范围，不是指代码，指数据的完整性

        if (ticketNums <= 0) {
            // 考虑没有票的情况，
            flag = false;
            return;
        }
        synchronized (this) {
            if (ticketNums <= 0) {
                // 考虑最后一张票
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
}
