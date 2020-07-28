package gof23.observer2;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 12:07
 */
public class ObserverA implements Observer {

    private int mySate;

    @Override
    public void update(Observable o, Object arg) {
        mySate = ((ConcreteSubject)o).getState();
    }

    public int getMySate() {
        return mySate;
    }

    public void setMySate(int mySate) {
        this.mySate = mySate;
    }
}
