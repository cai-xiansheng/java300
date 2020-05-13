package mypro11.cn.zh.syn;

import javax.swing.plaf.nimbus.State;
import java.util.LinkedList;

/**
 * @author 张辉
 * @Description 死锁
 * 死锁：过多的同步可能会造成互不释放资源，从而相互等待，一般发生于同步中持有多个对象的锁
 * 为了避免死锁的发生，不要在同一个代码块中，同时持有多个对象的锁。
 * @create 2020-05-13 20:33
 */
public class DeadLock {
    public static void main(String[] args) {
        Markup g1 = new Markup(1, "zs");
        Markup g2 = new Markup(0, "ls");
        g1.start();
        g2.start();

    }
}

class Lipstick {
    // 口红
}

class Mirror {
    // 镜子
}

class Markup extends Thread {
    // 化妆

    static final Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girl;


    public Markup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        // 化妆
        makup();
    }

    // 相互持有对方的锁--> 可能造成死锁
    private void makup() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girl + "获得口红");
                // 1秒后想拥有口红
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //synchronized (mirror) {
                //    System.out.println(this.girl + "获得镜子");
                //}
            }
            synchronized (mirror) {
                System.out.println(this.girl + "获得镜子");
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.girl + "获得镜子");
                // 2秒后想拥有口红
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //synchronized (lipstick) {
                //    System.out.println(this.girl + "获得口红");
                //}
            }
            synchronized (lipstick) {
                System.out.println(this.girl + "获得口红");
            }
        }
    }
}