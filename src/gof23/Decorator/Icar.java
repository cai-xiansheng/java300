package gof23.Decorator;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 17:42
 */
public interface Icar {
    void move();
}

// ConcreateComponent 具体构建角色（真实对象）
class Car implements Icar {
    @Override
    public void move() {
        System.out.println("陆地上跑！");
    }
}

// Decorator装饰器角色
class SuperCar implements Icar {
    protected Icar car;

    public SuperCar(Icar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

// Decorator装饰器角色
class FlyCar extends SuperCar {

    public FlyCar(Icar car) {
        super(car);
    }

    public void fly() {
        System.out.println("飞上天！");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

// Decorator装饰器角色
class WaterCar extends SuperCar {

    public WaterCar(Icar car) {
        super(car);
    }

    public void swing() {
        System.out.println("水上游！");
    }

    @Override
    public void move() {
        super.move();
        swing();
    }
}

// Decorator装饰器角色
class AICar extends SuperCar {

    public AICar(Icar car) {
        super(car);
    }

    public void autoMove() {
        System.out.println("自动驾驶！");
    }

    @Override
    public void move() {
        super.move();
        autoMove();
    }
}