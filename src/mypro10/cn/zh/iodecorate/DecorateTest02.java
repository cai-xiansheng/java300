package mypro10.cn.zh.iodecorate;

/**
 * @author 张辉
 * @Description 装饰设计模式——模拟咖啡
 * 1. 抽象组件：需要装饰的抽象对象（接口或抽象父类）
 * 2. 具体组件：需要装饰的对象
 * 3. 抽象装饰类：包含了抽象对象组件的引用以及修饰着共有组件的方法
 * 4. 具体装饰类：被装饰的对象
 * @create 2020-04-25 21:24
 */
public class DecorateTest02 {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink suger = new Sugar(coffee);
        System.out.println(suger.info() + "-->" + suger.cost());
        Drink milk = new Milk(coffee);
        System.out.println(milk.info() + "-->" + milk.cost());

        milk = new Milk(suger);
        System.out.println(milk.info() + "-->" + milk.cost());
    }
}


/**
 * 抽象组件
 */
interface Drink {
    double cost();

    String info();
}

/**
 * 抽象类
 */
class Coffee implements Drink {
    private String name = "原味咖啡";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

/**
 * 抽象装饰类
 */
class Decorate implements Drink {

    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

/**
 * 具体装饰类
 */
class Milk extends Decorate {
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() * 4;
    }

    @Override
    public String info() {
        return super.info() + "加入了牛奶！";
    }
}

/**
 * 具体装饰类
 */
class Sugar extends Decorate {
    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() * 2;
    }

    @Override
    public String info() {
        return super.info() + "加入了蔗糖！";
    }
}