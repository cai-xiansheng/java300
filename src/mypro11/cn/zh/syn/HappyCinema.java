package mypro11.cn.zh.syn;

import java.util.List;

/**
 * @author 张辉
 * @Description
 * @create 2020-05-13 19:18
 */
public class HappyCinema {
    public static void main(String[] args) {
        Cinema c = new Cinema(2,"zs");
        new Thread(new Customer(c,2),"老高").start();
        new Thread(new Customer(c,1),"张三").start();
    }
}

class Customer implements Runnable {
    // 顾客
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTicks(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + " -> 位置为：" + seats);
            } else {
                System.out.println("出票失败" + Thread.currentThread().getName() + " -> 位置不够");
            }
        }
    }
}


class Cinema {
    int available;
    String name;

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }


    public boolean bookTicks(int seats){
        // 购票
        System.out.println("可用位置为：" + available);
        if (seats > available) {
            return false;
        }
        available -= seats;
        return true;
    }
}
