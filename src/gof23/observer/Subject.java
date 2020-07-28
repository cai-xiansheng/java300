package gof23.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 11:45
 */
public class Subject {

    private List<Observer> list = new ArrayList<>();

    public void register(Observer obs) {
        list.add(obs);
    }

    public void registerObserver(Observer obs) {
        list.add(obs);
    }

    // 通知所有的观察者更新状态
    public void notifyAllObservers() {
        for (Observer obs : list) {
            obs.update(this);
        }
    }


}
