package mypro09.cn.zh.mycollection;

/**
 * @author 张辉
 * @Description 自定义实现ArrayList，体会底层原理
 * 增加泛型
 * @create 2020-04-07 22:49
 */
public class ZhArrayList02<E> {

    private Object[] elementData;
    private int size;

    private static final int DEFALT_CAPACITY = 10;

    public ZhArrayList02() {
        elementData = new Object[DEFALT_CAPACITY];
    }

    public ZhArrayList02(int capacity) {
        elementData = new Object[capacity];
    }

    public void add(E obj) {
        elementData[size++] = obj;
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
        ZhArrayList02 z1 = new ZhArrayList02(20);
        z1.add("aa");
        z1.add("bb");
        z1.add("CC");
        System.out.println(z1);
    }

}
