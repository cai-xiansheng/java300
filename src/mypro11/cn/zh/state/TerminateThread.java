package mypro11.cn.zh.state;

/**
 * @author 张辉
 * @Description 终止线程
 * 1. 线程正常执行完毕 --> 次数的限制
 * 2. 外部干涉 --> 加入标识
 *      1. 加入标记，标记线程体是否可以运行
 *      2. 在 run 中关联标识
 *      3. 对外提供方法，改变标识
 * 不要使用stop，destroy,这样的方法不安全
 * @create 2020-05-08 14:18
 */
public class TerminateThread implements Runnable {

    /**
     * 1. 加入标记，标记线程体是否可以运行
     */
    private boolean flag = true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        // 2. 关联标识 ，true --> 运行 false --> 停止
        while(flag) {
            System.out.println(name + "-->" + i++);
        }
    }

    /**
     * 3. 对外提供方法，改变标识
     */
    public void terminate(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread("rabbit");
        new Thread(tt).start();

        for (int i = 0; i < 100; i++) {
            if (i==88) {
                tt.terminate();
                System.out.println("tt game over");
            }

            System.out.println("main-->" + i);
        }
    }
}
