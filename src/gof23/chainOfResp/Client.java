package gof23.chainOfResp;

/**
 * @author 张辉
 * @Description 责任链模式
 * @create 2020-07-27 22:21
 */
public class Client {
    public static void main(String[] args) {
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader c = new GeneralManager("王五");

        // 组织责任链对象的关系
        a.setNextLeader(b);
        b.setNextLeader(c);

        // 开始请假操作
        LeaveRequest request1 = new LeaveRequest("Tom",10,"go home");
        a.handleRequest(request1);

    }
}
