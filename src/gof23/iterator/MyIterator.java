package gof23.iterator;

/**
 * @author 张辉
 * @Description 迭代器模式
 * @create 2020-07-27 22:34
 */
public interface MyIterator {
    void first(); // 将游标指向第一个元素
    void next(); // 将游标指向下一个元素
    boolean hasNext(); // 判断是否存在下一个元素
    boolean isFirst();
    boolean isLast();

    Object getCurrentObj(); // 获取当前游标指向对象
}
