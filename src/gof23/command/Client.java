package gof23.command;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 23:32
 */
public class Client {
    public static void main(String[] args) {
        Command c= new ConcreteCommand(new Receiver());

        Invoke i = new Invoke(c);

        i.call();
    }
}
