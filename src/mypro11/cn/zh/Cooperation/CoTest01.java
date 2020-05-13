package mypro11.cn.zh.Cooperation;

/**
 * @author 张辉
 * @Description 协作模式，生产者消费者实现方式一：管程法
 * 借助缓冲区
 * @create 2020-05-13 21:23
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

// 多线称的生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        // 生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产-->" + i + "个馒头");
            container.push(new Steamdbun(i));
        }
    }
}
// 消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        // 消费
        for (int i = 0; i < 100; i++) {
            System.out.println("消费-->" + container.pop().id + "个馒头");
        }
    }
}
// 缓冲区
class SynContainer{
    Steamdbun[] buns = new Steamdbun[10];// 存储数据的容器
    int count = 0; // 计数器

    // 存储
    public synchronized void push(Steamdbun bun){
        // 合适能生产 容器存在空间
        // 不能生产
        if(count == buns.length) {
            try {
                this.wait(); // 线程阻塞， 消费者通知，解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // 存在空间，可以生产
        buns[count] = bun;
        count++;
        this.notifyAll();// 存在数据了，可以通知消费了
    }
    // 获取
    public synchronized Steamdbun pop(){
        // 何时消费，容器中是否有数据
        // 没有数据只能等待
        if(count == 0) {
            try {
                this.wait(); // 线程阻塞 生产者通知，解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 存在数据，可以消费
        count--;
        Steamdbun bun = buns[count];
        this.notifyAll();// 存在空间可以唤醒对方生产

        return bun;
    }
}
// 馒头
class Steamdbun{
    int id;

    public Steamdbun(int id) {
        this.id = id;
    }
}