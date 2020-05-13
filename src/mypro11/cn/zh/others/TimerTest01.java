package mypro11.cn.zh.others;

import java.util.*;

/**
 * @author 张辉
 * @Description 任务定时调度：Timer 和 TimerTask类
 * @create 2020-05-13 22:04
 */
public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //timer.schedule(new MYTask(),1000);// 执行任务一次
        //timer.schedule(new MYTask(),1000,200); // 执行多次
        Calendar cal = new GregorianCalendar(2999,12,31,21,35,54);
        timer.schedule(new MYTask(), cal.getTime(),200);// 5s后执行一次
    }
}


class MYTask extends TimerTask {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello world");
        }
        System.out.println("end_______");
    }
}