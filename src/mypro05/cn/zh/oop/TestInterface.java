package mypro05.cn.zh.oop;

/**
 * @author 张辉
 * @Description 测试接口和实现类
 * java 类没有多继承，接口有多继承
 * @create 2020-04-06 16:06
 */
public interface TestInterface {
    public static void main(String[] args) {
        Volant v = new Angle();
        v.fly();

        Honest h = new GoodMan();
        h.helpOther();
    }
}

/**
 * 飞行接口
 */
interface Volant {
    int FLY_HEIGHT = 1000;

    void fly();
}

interface Honest {
    void helpOther();
}

class Angle implements Volant, Honest {
    /**
     * 接口可以多实现
     */

    @Override
    public void helpOther() {
        System.out.println("Angle help other!");
    }

    @Override
    public void fly() {
        System.out.println("AngleFly!");
    }
}


class GoodMan implements Honest {

    @Override
    public void helpOther() {
        System.out.println("fly fly");
    }
}
