package mypro09.cn.zh.mycollection;

/**
 * @author 张辉
 * @Description 自定义实现ArrayList，体会底层原理
 * 02版本：增加泛型
 * 03版本：增加数组扩容功能
 * 04版本：增加set,get方法，增加数组边界的检查
 * 05版本：增加删除方法
 * @create 2020-04-07 22:49
 */
public class ZhArrayList05<E> {

    private Object[] elementData;
    private int size;

    private static final int DEFALT_CAPACITY = 10;

    public ZhArrayList05() {
        elementData = new Object[DEFALT_CAPACITY];
    }

    public ZhArrayList05(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("容器的容量不能为负数");
        } else if (capacity == 0) {
            elementData = new Object[DEFALT_CAPACITY];
        } else {
            elementData = new Object[capacity];
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public void add(E element) {

        // 什么时候扩容？？？
        if (size == elementData.length) {
            // 怎么扩容
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1) + 1];
            // 相当于10-->10+10/2
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
            // 把新的数组引用地址给原来的数组名。
        }
        elementData[size++] = element;
    }

    public E get(int index) {
        checkRange(index);
        return (E) elementData[index];
    }

    public void set(int index, E element) {
        // 索引合法[0,size)
        checkRange(index);
        elementData[index] = element;
    }

    public void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            // 不合法
            throw new RuntimeException("索引不合法:" + index);
        }
    }

    public void remove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    public void remove(E element) {
        // element 将他和所有元素挨个比较，获得第一个比较为true的，返回。
        for (int i = 0; i < size; i++) {
            if (element.equals(get(i))) {
                // 容器中的所有比较操作都是使用的equals而不是==
                // 将该元素从此处移除
                remove(i);
            }
        }
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
        ZhArrayList05 z1 = new ZhArrayList05(1);
        int s = 40;
        for (int i = 0; i < s; i++) {
            z1.add("z" + i);
        }
        z1.set(10, "wo");
        z1.remove(10);
        System.out.println(z1);
        System.out.println(z1.get(10));
        System.out.println(z1.size());
    }

}
