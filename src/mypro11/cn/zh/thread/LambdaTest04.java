package mypro11.cn.zh.thread;

/**
 * @author 张辉
 * @Description Lambda推导
 * @create 2020-05-08 13:20
 */
public class LambdaTest04 {

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 3;i++){
                System.out.println("一边学习lambda");
            }
        }).start();

        new Thread(() -> System.out.println("一边崩溃中")).start();

    }
}

