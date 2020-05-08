package mypro11.cn.zh.thread;

/**
 * @author 张辉
 * @Description Lambda推导
 * @create 2020-05-08 13:20
 */
public class LambdaTest01 {
    /**
     * 静态内部类 local class
     */
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        /**
         * 方法内部类
         */
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like2();
        like.lambda();

        // 匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();


        // lambda jdk8 推荐使用lambda lambda推到必须存在类型
        like = ()->{
            System.out.println("I like lambda5");
        };
        like.lambda();

    }
}

interface ILike{
    /**
     * a
     */
    void lambda();

    /**
     * b
     */
    //void lambda2();
}

/**
 * 外部类
 */
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
