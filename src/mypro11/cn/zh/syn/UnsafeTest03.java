package mypro11.cn.zh.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description 线程不安全：操作容器
 * @create 2020-05-08 23:56
 */
public class UnsafeTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        System.out.println(list.size());
    }

}
