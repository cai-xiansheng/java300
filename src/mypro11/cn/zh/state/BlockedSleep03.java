package mypro11.cn.zh.state;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张辉
 * @Description sleep模拟倒计时
 * 1. sleep(时间)指定当前线程阻塞的毫秒数
 * 2. sleep存在异常InterruptedException
 * 3. sleep时间达到后线程进入就绪状态
 * 4. sleep可以模拟网络延时、倒计时等。
 * 5. 每个对象都有一个锁，sleep不会释放锁（抱着CPU睡觉）
 * @create 2020-05-08 14:36
 */
public class BlockedSleep03 {
    public static void main(String[] args) throws InterruptedException {
        // 倒计时
        Date endTime = new Date(System.currentTimeMillis() + 1000*10);
        long end = endTime.getTime();
        while (true) {
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()-1000);

            if (end-10000 > endTime.getTime()) {
                break;
            }
        }
    }

    public static void test() throws InterruptedException {
        // 倒数10个数，1s一个
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
        }
    }
}
