package mypro11.cn.zh.state;

/**
 * @author 张辉
 * @Description 观察线程的状态
 * @create 2020-05-08 22:39
 */
public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("...");
            }
        });

        Thread.State state = t.getState();
        // NEW
        System.out.println(state);

        t.start();
        state = t.getState();
        // RUNNABLE
        System.out.println(state);

        //while (state != Thread.State.TERMINATED) {
        //    try {
        //        Thread.sleep(200);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //    state = t.getState();
        //    // TIMED_WAITING
        //    System.out.println(state);
        //}

        //    state = t.getState();
        //    // TERMINATED
        //    System.out.println(state);

        while (true) {
            // 活动的线程数
            int num = Thread.activeCount();
            System.out.println(num);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState();
            // TIMED_WAITING
            System.out.println(state);
        }
    }
}
