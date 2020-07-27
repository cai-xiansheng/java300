package gof23.adapter;

/**
 * @author 张辉
 * @Description 适配器（相当于USB和PS/2的转换器）
 * @create 2020-07-27 11:17
 */
public class Adapter2 extends Adaptee implements Target {

    private Adaptee adaptee;

    @Override
    public void handleReq() {
        adaptee.request();
    }

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
