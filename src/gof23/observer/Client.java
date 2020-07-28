package gof23.observer;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 11:56
 */
public class Client {
    public static void main(String[] args) {
        // 目标对象
        ConcreteSubject subject = new ConcreteSubject();


        // 创建多个观察者
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();

        // 将这三个观察者添加到subject对象的观察者队伍中
        subject.registerObserver(obs1);
        subject.registerObserver(obs2);
        subject.registerObserver(obs3);

        // 改变subject的装填
        subject.setState(3000);

        // 让我们看看，观察者的装填是不是也发生了变化
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

        // 改变subject的装填
        subject.setState(30);

        // 让我们看看，观察者的装填是不是也发生了变化
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());
    }
}
