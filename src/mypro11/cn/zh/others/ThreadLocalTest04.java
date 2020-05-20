package mypro11.cn.zh.others;

/**
 * @author 张辉
 * @Description InheritableThreadLocal
 * InheritableThreadLocal ：继承上下文 环境的数据，拷贝一份数据给子线程
 * @create 2020-05-14 12:35
 */
public class ThreadLocalTest04 {
    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set(2);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());

        // 线程由main 线程开辟
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
            threadLocal.set(200);
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());

        }).start();
    }
}
