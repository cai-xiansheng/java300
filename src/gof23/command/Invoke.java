package gof23.command;

/**
 * @author 张辉
 * @Description 命令的调用者和发起者
 * @create 2020-07-27 23:30
 */
public class Invoke {
    private Command command; // 也可以通过容器List<Command>容纳很多命令对象，进行批处理，数据库底层的事物就是类似的结构！

    public Invoke(Command command) {
        this.command = command;
    }

    // 业务方法，用于调用命令类的方法
    public void call() {
        command.execute();
    }
}
