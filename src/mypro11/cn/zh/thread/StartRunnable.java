package mypro11.cn.zh.thread;

/**
 * @author 张辉
 * @Description 创建线程（Runnable）
 * 创建线程方式二：
 * 1. 创建：继承Runnable + 重写run
 * 2. 启动：创建子类对象 + Thread对象 + start
 *
 * 推荐：避免单继承的局限性，有限使用接口
 * 方便资源共享
 * @create 2020-05-08 8:38
 */
public class StartRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌！");
        }
    }

    public static void main(String[] args) {
        // 创建实现类对象
        //StartRunnable sr = new StartRunnable();
        //// 创建代理类对象
        //Thread t = new Thread(sr);
        //// 启动
        //t.start();

        new Thread(new StartRunnable()).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("一边coding");
        }
    }
}
