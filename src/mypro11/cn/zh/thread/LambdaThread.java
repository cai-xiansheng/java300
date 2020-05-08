package mypro11.cn.zh.thread;

/**
 * @author 张辉
 * @Description Lambda表达式，简化线程（用一次）的使用
 * @create 2020-05-08 8:38
 */
public class LambdaThread {

    /**
     * 静态内部类
     */
    static class Test implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("一边听歌！");
            }
        }
    }



    public static void main(String[] args) {

        //new Thread(new Test()).start();

        // 局部内部类
        class Test2 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边听歌！");
                }
            }
        }

        new Thread(new Test2()).start();

        // 匿名内部类，必须借助接口或父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("dance");
                }
            }
        }).start();

        //jdk8简化 lambda(lambda用来简化简单的线程类，lambda只能推到接口里面的一个方法，如果由多个方法，那么就不行)
        new Thread (()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("dance");
            }
        }).start();
    }
}
