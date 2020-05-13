package mypro11.cn.zh.syn;

/**
 * @author 张辉
 * @Description 线程安全：取钱
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1. 同步方法
 * 2. 同步块
 * @create 2020-05-08 23:43
 */
public class SafeTest02 {
    public static void main(String[] args) {
        // 账户
        SafeAccount safeAccount = new SafeAccount(100,"结婚礼金");
        SafeDrawing you = new SafeDrawing(safeAccount,80,"你");
        SafeDrawing wife = new SafeDrawing(safeAccount,90,"她");
        you.start();
        wife.start();

    }

}

class SafeAccount {
    int money;
    String name;

    public SafeAccount(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class SafeDrawing extends Thread {
    SafeAccount safeAccount;
    int drawingMoney;
    int packetTotal;

    public SafeDrawing(SafeAccount account, int drawingMoney, String name) {
        super(name);
        this.safeAccount = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        this.test();
    }

    private synchronized void test(){
        // 目标不对，锁定失败，这里不是锁定this，而是锁定account
        if (safeAccount.money - drawingMoney <0) {
            return;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        safeAccount.money -= drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName() + "-->账户余额为：" + safeAccount.money);
        System.out.println(this.getName() + "-->口袋的钱：" + packetTotal);
    }
}
