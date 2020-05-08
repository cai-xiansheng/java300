package mypro11.cn.zh.thread;

import java.util.concurrent.*;

/**
 * @author 张辉
 * @Description 模拟龟兔赛跑
 * @create 2020-05-08 8:59
 */
public class CRacer implements Callable<Integer> {
    private static String winner;

    @Override
    public Integer call() throws Exception{
        for (int i = 1; i <= 100; i++) {
            // 模拟休息
            if ("pool-1-thread-1".equals(Thread.currentThread().getName()) && ((i % 10) == 0)) {
                    Thread.sleep(100);
            }

            System.out.println(Thread.currentThread().getName() + "-->" + i);
            // 比赛是否结束
            boolean flag = gameOver(i);
            if (flag) {
                return i;
            }
        }
        return null;
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CRacer racer = new CRacer();


        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Integer> reslut1 = service.submit(racer);
        Future<Integer> reslut2 = service.submit(racer);
        // 获取结果
        Integer r1 = reslut1.get();
        Integer r2 = reslut2.get();
        System.out.println(r2);
        // 关闭服务
        service.shutdownNow();
    }
}
