package gof23.command;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 23:27
 */
public interface Command {
    /**
     * 这个方法是一个返回结果为空的方法
     * 在实际项目中，可以根据需求设计多个不同的方法
     */
    void execute();
}

class ConcreteCommand implements Command {

    private Receiver receiver; // 真正的命令执行者

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        // 命令真正执行前、后，执行相关的处理！
        receiver.action();
    }
}
