package gof23.memento;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-28 12:29
 */
public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();

        Emp emp = new Emp("张三", 18, 900);
        System.out.println("第一次创建对象：" + emp.geteName() + "---" + emp.getAge() + "---" + emp.getSalary());

        taker.setMemento(emp.memento()); // 备忘一次

        emp.setAge(38);
        emp.seteName("高淇");
        emp.setSalary(9000);
        System.out.println("第二次创建对象：" + emp.geteName() + "---" + emp.getAge() + "---" + emp.getSalary());


        emp.recovery(taker.getMemento()); // 恢复到备忘录对象保存的状态
        System.out.println("第三次创建对象：" + emp.geteName() + "---" + emp.getAge() + "---" + emp.getSalary());
    }
}
