package mypro11.cn.zh.state;


/**
 * @author 张辉
 * @Description sleep模拟休息
 * 1. sleep(时间)指定当前线程阻塞的毫秒数
 * 2. sleep存在异常InterruptedException
 * 3. sleep时间达到后线程进入就绪状态
 * 4. sleep可以模拟网络延时、倒计时等。
 * 5. 每个对象都有一个锁，sleep不会释放锁（抱着CPU睡觉）
 * @create 2020-05-08 14:36
 */
public class BlockedSleep02 {
    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();
    }
}

class Racer implements Runnable {
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


}

