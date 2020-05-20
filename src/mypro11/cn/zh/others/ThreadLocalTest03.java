package mypro11.cn.zh.others;

/**
 * @author 张辉
 * @Description ThreadLocal
 * ThreadLocal ：分析上下文环境 起点
 * 1. 构造器：那里调用，就属于哪里 找线程体
 * 2. run方法，线程自身的
 * get/set/initialValue
 * @create 2020-05-14 12:35
 */
public class ThreadLocalTest03 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);

    public static void main(String[] args) {
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{

        public  MyRun(){
            System.out.println(Thread.currentThread().getName() + "剩下-->" + threadLocal.get());
        }
        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "得到-->" + left);
            threadLocal.set(left-1);
            System.out.println(Thread.currentThread().getName() + "剩下-->" + threadLocal.get());

        }
    }
}
