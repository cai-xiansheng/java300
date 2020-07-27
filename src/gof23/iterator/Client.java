package gof23.iterator;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 22:45
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMyAggregate cma = new ConcreteMyAggregate();

        cma.addObject("aa");
        cma.addObject("bb");
        cma.addObject("cc");
        cma.addObject("dd");

        MyIterator iter = cma.createIterator();
        while (iter.hasNext()) {
            System.out.println(iter.getCurrentObj());
            iter.next();
        }
    }
}
