package javaExam.task02;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-02 23:21
 */
public class ArithmeticExpression {
    /**
     * 左操作数
     * 右操作数
     * 操作符
     */
    private double x;
    private double y;
    private double operator;

    public ArithmeticExpression(String string) {
        int index = 0;
        while (index < string.length()) {
            String ch = string.substring(index,index+1);
            System.out.println(ch==1);
            index++;
        }
    }

    public static void main(String[] args) {
        ArithmeticExpression a = new ArithmeticExpression("1+2");
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getOperator() {
        return operator;
    }

}
