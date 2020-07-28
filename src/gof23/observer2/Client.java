package gof23.observer2;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 12:10
 */
public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        ConcreteSubject subject = new ConcreteSubject();


        // 创建观察者
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();

        // 将上面三个观察者对象添加到目标对象Subject的观察者容器中
        subject.addObserver(obs1);
        subject.addObserver(obs2);
        subject.addObserver(obs3);

        // 改变subject对象的状态
        subject.set(3000);


        // 观察者的状态发生了变化
        System.out.println(obs1.getMySate());
        System.out.println(obs2.getMySate());
        System.out.println(obs3.getMySate());


        // 改变subject对象的状态
        subject.set(400);


        // 观察者的状态发生了变化
        System.out.println(obs1.getMySate());
        System.out.println(obs2.getMySate());
        System.out.println(obs3.getMySate());
    }
}
