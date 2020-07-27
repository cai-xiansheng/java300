package gof23.mediator;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 22:56
 */
public interface Department {
    void selfAction(); // 做本部门的事情
    void outAction(); // 向总经理发出申请
}
