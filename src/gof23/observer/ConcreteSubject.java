package gof23.observer;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 11:50
 */
public class ConcreteSubject extends Subject {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;

        this.notifyAllObservers();
    }
}
