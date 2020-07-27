package gof23.chainOfResp;

/**
 * @author 张辉
 * @Description 主任
 * @create 2020-07-27 22:14
 */
public class Director extends Leader {
    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDay() < 3) {
            System.out.println("员工：" + request.getEmpName() + "请假，天数：" + request.getLeaveDay() + "，理由：" + request.getReason());
            System.out.println("主任：" + this.name + "，审批通过！");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
