package gof23.adapter;

/**
 * @author 张辉
 * @Description 适配器（相当于USB和PS/2的转换器）
 * @create 2020-07-27 11:17
 */
public class Adapter extends Adaptee implements Target{

    @Override
    public void handleReq() {
        super.request();
    }
}
