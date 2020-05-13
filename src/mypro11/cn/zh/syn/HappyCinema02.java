package mypro11.cn.zh.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description
 * @create 2020-05-13 19:18
 */
public class HappyCinema02 {
    public static void main(String[] args) {
        // 准备位置
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(5);
        available.add(6);

        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);

        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);
        ZsCinema c = new ZsCinema(available, "zs");
        new Thread(new HappyCustomer(c, seats1), "老高").start();
        new Thread(new HappyCustomer(c, seats2), "张三").start();
    }
}

class HappyCustomer implements Runnable {
    // 顾客
    ZsCinema cinema;
    List<Integer> seats;

    public HappyCustomer(ZsCinema cinema, List<Integer> seats) {
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


class ZsCinema {
    List<Integer> available;
    String name;

    public ZsCinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }


    public boolean bookTicks(List<Integer> seats) {
        // 购票
        System.out.println("欢迎光临" + this.name + "可用位置为：" + available);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(available);

        // 相减
        copy.removeAll(seats);
        // 判断大小
        if (available.size() - copy.size() > seats.size()) {
            return false;
        }
        // 成功
        available = copy;
        return true;
    }
}
