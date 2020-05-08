package mypro11.cn.zh.state;


/**
 * @author 张辉
 * @Description join：合并线程，插队线程
 * @create 2020-05-08 16:28
 */
public class BlockedJoin02 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("儿子给爸爸买烟的故事！");
        new Thread(new Father()).start();
    }
}

class Father extends Thread{
    @Override
    public void run() {
        System.out.println("想抽烟，发现没了");
        System.out.println("让儿子去买烟");
        Thread t = new Thread(new Son());
        t.start();
        try {
            t.join();
            // father被阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("孩子走丢了，老爸 去找孩子了！");
        }
        System.out.println("老爸接过烟，把零钱给儿子！");
    }
}

class Son extends Thread{
    @Override
    public void run() {
        System.out.println("接过老爸的钱，出去了。。。");
        System.out.println("路边有个游戏厅，完了10s");
        int num = 10;
        for (int i = 0; i < num; i++) {
            System.out.println(i + "秒过去了。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("赶紧去买烟！");
        System.out.println("手拿一包烟回家了！");
    }
}
