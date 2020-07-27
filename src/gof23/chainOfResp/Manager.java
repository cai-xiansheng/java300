package gof23.chainOfResp;

/**
 * @author 张辉
 * @Description 经理
 * @create 2020-07-27 22:14
 */
public class Manager extends Leader {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDay() < 10) {
            System.out.println("员工：" + request.getEmpName() + "请假，天数：" + request.getLeaveDay() + "，理由：" + request.getReason());
            System.out.println("经理：" + this.name + "，审批通过！");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
