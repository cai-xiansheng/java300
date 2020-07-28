package gof23.memento;

import java.util.Stack;

/**
 * @author 张辉
 * @Description 管理备忘录对象
 * @create 2020-07-28 12:27
 */
public class CareTaker {
    private EmpMemento memento;

    // 可以保存多个
    private Stack<EmpMemento> stack = new Stack<>();

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
