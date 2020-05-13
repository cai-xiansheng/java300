package mypro11.cn.zh.syn;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description 线程安全：操作并发容器
 * @create 2020-05-13 20:26
 */
public class SyncContainer {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
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
