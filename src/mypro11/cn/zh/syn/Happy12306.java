package mypro11.cn.zh.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description
 * @create 2020-05-13 19:18
 */
public class Happy12306 {
    public static void main(String[] args) {
        Web12306 c = new Web12306(2, "zs");
        new Passenger(c,"老高",2).start();
        new Passenger(c,"老配",1).start();
    }
}

class Passenger extends Thread {
    // 顾客
    int seats;

    public Passenger( Runnable target,String name,int seats) {
        super(target,name);
        this.seats = seats;
    }
}

class Web12306 implements Runnable {
    int available;
    String name;

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger p = (Passenger) Thread.currentThread();
        boolean flag = this.bookTicks(p.seats);
        if (flag) {
            System.out.println("出票成功" + Thread.currentThread().getName() + " -> 位置为：" + p.seats);
        } else {
            System.out.println("出票失败" + Thread.currentThread().getName() + " -> 位置不够");
        }
    }

    public synchronized boolean bookTicks(int seats) {
        // 购票
        System.out.println("可用位置为：" + available);
        if (seats > available) {
            return false;
        }
        available -= seats;
        return true;
    }
}
