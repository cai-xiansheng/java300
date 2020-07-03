package javaExam.task02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-02 23:21
 */
@SuppressWarnings("all")
public class ArithmeticExpression {
    /**
     * 左操作数
     * 右操作数
     * 操作符
     */
    private double x;
    private double y;
    private String operator;

    public ArithmeticExpression(String string) {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add(".");
        int index = 0;
        int beg = 0;
        while (index < string.length()) {
            String ch = string.substring(index, index + 1);
            if (!list.contains(ch)) {
                beg = index;
                break;
            }
            index++;
        }
        operator = string.substring(beg, beg + 1);
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("\\")) {
            // 操作符正常
        } else {
            System.out.println("操作符异常！！！");
        }
        x = Double.parseDouble(string.substring(0, beg));
        y = Double.parseDouble(string.substring(beg + 1, string.length()));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getOperator() {
        return operator;
    }

    public double getResult() {
        if (y == 0) {
            System.out.println("被除数不能为0");
            return -1.0;
        }
        double result = 0;
        switch (operator) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "\\":
                result = x / y;
                break;
            default:
        }

        return result;
    }

}
