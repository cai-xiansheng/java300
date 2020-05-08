package mypro11.cn.zh.state;

import javax.swing.plaf.nimbus.State;

/**
 * @author 张辉
 * @Description 守护线程：是为用户线程服务的；JVM停止不用等待守护线程执行完毕
 * 默认：用户线程 JVM需要等待所有的线程执行完毕，才会停止
 * @create 2020-05-08 23:06
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        // 代理
        Thread t = new Thread(god);
        t.setDaemon(true);
        // 将用户线程调整为守护线程
        t.start();
        new Thread(you).start();

    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 365*100; i++) {
            System.out.println("happy life...");
        }
        System.out.println("oooooooooooo...");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 365*1000000; i++) {
            System.out.println("bless you...");
        }
        System.out.println("oooooooooooo...");
    }
}