package mypro11.cn.zh.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description 线程安全：操作容器
 * synchronized
 * 1. 同步方法 直接给方法加synchronized
 * 2. 同步块 synchronized (要锁的对象){}
 * @create 2020-05-13 17:24
 */
public class SyncBlock02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 2000; i++) {
            new Thread(()->{
                // 同步块
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
