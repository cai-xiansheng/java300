package gof23.mediator;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 22:55
 */
public interface Mediator {
    void register(String dName,Department d);
    void command(String dName);
}
