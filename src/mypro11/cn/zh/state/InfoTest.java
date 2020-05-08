package mypro11.cn.zh.state;

import java.sql.SQLOutput;

/**
 * @author 张辉
 * @Description 线程的其他方法
 * 1. isAlive():线程是否还活着
 * 2. Thread.currentThread():当前线程
 * 3. setName()、getName:代理的名称
 * @create 2020-05-08 23:16
 */
public class InfoTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());

        // 设置名称：真实角色+代理角色
        MyInfo info = new MyInfo("战斗机");
        Thread t= new Thread(info);
        t.setName("joy");
        // 代理角色（代理角色）
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());

    }
}

class MyInfo implements Runnable{

    // 真实角色
    private String name;

    public MyInfo(String name) {
        this.name = name;
    }

    public MyInfo(){

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "-->" + name);

    }
}