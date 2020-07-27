package gof23.bridge;

/**
 * @author 张辉
 * @Description 电脑的品牌
 * @create 2020-07-27 16:49
 */
public interface Brand {
    void sale();
}

class Lenovo implements Brand{
    @Override
    public void sale() {
        System.out.println("Lenovo.sale");
    }
}

class Dell implements Brand {
    @Override
    public void sale() {
        System.out.println("Dell.sale");
    }
}

class Shenzhou implements Brand {
    @Override
    public void sale() {
        System.out.println("Shenzhou.sale");
    }
}