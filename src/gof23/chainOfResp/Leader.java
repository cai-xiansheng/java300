package gof23.chainOfResp;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 22:08
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader; // 责任链上的后继对象

    public Leader(String name) {
        this.name = name;
    }

    // 设定责任链上的后继对象
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求的核心业务方法
     * @param request
     */
    public abstract void handleRequest(LeaveRequest request);
}
