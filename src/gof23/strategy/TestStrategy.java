package gof23.strategy;

/**
 * @author 张辉
 * @Description 策略模式，实现起来比较容易，符合一般开发人员的思路。
 * 假如，类型特别多，算法比较复杂时，整个条件语句的代码就变得很长，难于维护
 * 如果有新增类型，就需要频繁的修改此处的代码
 * @create 2020-07-28 9:22
 */
public class TestStrategy {
    public double getPrice(String type, double price) {
        if ("普通客户小批量".equals(type)) {
            System.out.println("不打折，原价");
            return price;
        } else if ("普通客户大批量".equals(type)) {
            System.out.println("打九折");
            return price * 0.9;
        } else if ("老客户小批量".equals(type)) {
            System.out.println("打八五折");
            return price * 0.85;
        } else if ("老客户大批量".equals(type)) {
            System.out.println("打八折");
            return price * 0.8;
        }
        return price;
    }
}
