package mypro11.cn.zh.thread;

/**
 * @author 张辉
 * @Description Lambda推导 + 参数
 * @create 2020-05-08 13:20
 */
public class LambdaTest02 {

    public static void main(String[] args) {
        ILove love = (int a) -> {
            System.out.println("I like lambda-->" + a);
        };

        love.lambda(100);

        // 简化
        love = (a) -> {
            System.out.println("I like lambda-->" + a);
        };
        love.lambda(200);

        // 简化 如果是一个参数，括号也可以省略
        love = a -> {
            System.out.println("I like lambda-->" + a);
        };
        love.lambda(300);

        // 简化 如果是一个参数，并且里边也是一个语句，那么花括号也可以省略
        love = a -> System.out.println("I like lambda-->" + a);
        love.lambda(400);

    }
}

interface ILove {
    /**
     * a
     */
    void lambda(int a);

    /**
     * b
     */
    //void lambda2();
}

/**
 * 外部类
 */
class Love implements ILove {
    @Override
    public void lambda(int a) {
        System.out.println("I like lambda-->" + a);
    }
}
