package gof23.bridge;

/**
 * @author 张辉
 * @Description 电脑的类型
 * @create 2020-07-27 16:50
 */
public class Computer2 {

    /**
     * 这是桥接模式最重要的部分
     * 就是在一个类中把另外一个类当成一个属性加入进去
     */

    protected Brand brand;

    public Computer2(Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        brand.sale();
    }
}

class Desktop2 extends Computer2 {

    public Desktop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("Desktop2.sale");
    }
}

class Laptop2 extends Computer2 {

    public Laptop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("Laptop2.sale");
    }
}