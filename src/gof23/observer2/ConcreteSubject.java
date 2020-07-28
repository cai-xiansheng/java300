package gof23.observer2;

import java.util.Observable;

/**
 * @author 张辉
 * @Description 目标对象
 * @create 2020-07-28 12:03
 */
public class ConcreteSubject extends Observable {

    private int state;

    public void set(int s) {
        state = s; // 目标对象的状态发生了改变

        setChanged(); // 表示目标对象已经做了改变
        notifyObservers(state); // 通知所有的观察者
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
