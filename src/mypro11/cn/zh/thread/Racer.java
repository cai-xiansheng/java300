package mypro11.cn.zh.thread;

/**
 * @author 张辉
 * @Description 模拟龟兔赛跑
 * @create 2020-05-08 8:59
 */
public class Racer implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            // 模拟休息
            if ("rabbit".equals(Thread.currentThread().getName()) && ((i % 10) == 0)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "-->" + i);
            // 比赛是否结束
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            // 存在胜利者了
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner==>" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();
    }
}
