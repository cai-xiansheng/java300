package mypro11.cn.zh.thread;

/**
 * @author 张辉
 * @Description 静态代理
 * 接口
 * 1. 真实角色
 * 2. 代理角色
 * @create 2020-05-08 12:58
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
        //new Thread(线程对象).start();
    }
}

interface Marry{
    /**
     * 结婚的接口
     */
    void happyMarry();
}

class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("you and you girlfriend 。。。");
    }
}

/**
 * 代理角色
 */
class WeddingCompany implements Marry{
    /**
     * 真实角色
     */
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        this.ready();
        this.target.happyMarry();
        this.after();
    }

    private void ready(){
        System.out.println("布置主卧！");
    }

    private void after(){
        System.out.println("闹洞房！");
    }
}