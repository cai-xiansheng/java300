package mypro10.cn.zh.iodecorate;

/**
 * @author 张辉
 * @Description 装饰设计模式
 * @create 2020-04-25 21:15
 */
public class DecorateTest01 {
    public static void main(String[] args) {
        Person p =new Person();
        p.say();

        Amplifier am = new Amplifier(p);
        am.say();
    }
}

interface Say{
    void say();
}

class Person implements Say{

    // 属性
    private int voice = 10;

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    @Override
    public void say() {
        System.out.println("人的声音为："+this.getVoice());
    }
}


class Amplifier implements Say{

    private Person p;

    // 装饰
    public Amplifier(Person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音为："+p.getVoice()*100);
        System.out.println("噪音！！！！！！！！！！");
    }
}
