package gof23.mediator;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 22:57
 */
public class Finacial implements Department {
    private Mediator m; // 持有中介者（总经理）的引用

    public Finacial(Mediator m) {
        this.m = m;
        m.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心数钱");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作，钱太多，怎么花");

    }
}
