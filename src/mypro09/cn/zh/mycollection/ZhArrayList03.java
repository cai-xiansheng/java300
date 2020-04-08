package mypro09.cn.zh.mycollection;

/**
 * @author 张辉
 * @Description 自定义实现ArrayList，体会底层原理
 * 02版本：增加泛型
 * 03版本：增加数组扩容功能
 * @create 2020-04-07 22:49
 */
public class ZhArrayList03<E> {

    private Object[] elementData;
    private int size;

    private static final int DEFALT_CAPACITY = 10;

    public ZhArrayList03() {
        elementData = new Object[DEFALT_CAPACITY];
    }

    public ZhArrayList03(int capacity) {
        elementData = new Object[capacity];
    }

    public void add(E element) {

        // 什么时候扩容？？？
        if (size == elementData.length) {
            // 怎么扩容
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            // 相当于10-->10+10/2
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
            // 把新的数组引用地址给原来的数组名。
        }
        elementData[size++] = element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ZhArrayList03 z1 = new ZhArrayList03(1);
        for (int i = 0; i < 40; i++) {
            z1.add("z" + i);
        }
        System.out.println(z1);
    }

}
