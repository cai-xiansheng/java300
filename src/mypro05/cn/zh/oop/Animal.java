package mypro05.cn.zh.oop;

/**
 * @author 张辉
 * @Description abstract（抽象类）：存在的意义，为子类提供统一的、规范的模板。子类必须实现
 * @create 2020-04-06 14:43
 */
public abstract class Animal {
    /**
     * 1. 没有实现(abstract)
     * 2. 子类必须实现*/
    /**
     * 抽象类的使用要点:
     *      1. 有抽象方法的类只能定义成抽象类
     *      2. 抽象类不能实例化，即不能用new来实例化抽象类。
     *      3. 抽象类可以包含属性、方法、构造方法。但是构造方法不能用来new实例，只能用来被子类调用。
     *      4. 抽象类只能用来被继承。
     *      5. 抽象方法必须被子类实现。
     */
    abstract public void shut();
    public void run(){
        System.out.println("跑跑跑！");
    };
}

class Dog extends Animal{

    @Override
    public void shut() {
        System.out.println("汪汪汪！");
    }
}
