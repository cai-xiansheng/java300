package gof23.chainOfResp;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 22:07
 */
public class LeaveRequest {
    private String empName;
    private int leaveDay;
    private String reason;

    public LeaveRequest(String empName, int leaveDay, String reason) {
        this.empName = empName;
        this.leaveDay = leaveDay;
        this.reason = reason;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(int leaveDay) {
        this.leaveDay = leaveDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
