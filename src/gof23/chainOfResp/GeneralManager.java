package gof23.chainOfResp;

/**
 * @author 张辉
 * @Description 总经理
 * @create 2020-07-27 22:14
 */
public class GeneralManager extends Leader {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDay() < 30) {
            System.out.println("员工：" + request.getEmpName() + "请假，天数：" + request.getLeaveDay() + "，理由：" + request.getReason());
            System.out.println("总经理：" + this.name + "，审批通过！");
        } else {
            System.out.println("莫非" + request.getEmpName() + "想辞职！！！");
        }
    }
}
