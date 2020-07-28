package gof23.observer;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 11:52
 */
public class ObserverA implements Observer {

    private int myState; // myState需要跟目标对象的state值保持一致！

    @Override
    public void update(Subject subject) {
       myState = ((ConcreteSubject)subject).getState();
    }

    public int getMyState() {
        return myState;
    }
}
