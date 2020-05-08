package mypro11.cn.zh.thread;

/**
 * @author 张辉
 * @Description Lambda推导 + 参数 + 返回值
 * @create 2020-05-08 13:20
 */
public class LambdaTest03 {

    public static void main(String[] args) {
        IInterest interest = (int a, int b) -> {
            System.out.println("I like lambda-->" + (a + b));
            return a + b;
        };
        interest.lambda(100, 200);


        interest = (a, b) -> {
            System.out.println("I like lambda-->" + (a + b));
            return a + b;
        };
        interest.lambda(200, 300);


        interest = (a, b) -> a + b;

        System.out.println(interest.lambda(20, 30));

    }
}

interface IInterest {
    /**
     * a
     */
    int lambda(int a, int b);
}

/**
 * 外部类
 */
class Interest implements IInterest {
    @Override
    public int lambda(int a, int b) {
        System.out.println("I like lambda-->" + (a + b));
        return a + b;
    }
}
