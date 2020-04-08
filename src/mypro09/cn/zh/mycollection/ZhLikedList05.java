package mypro09.cn.zh.mycollection;

import java.util.Vector;

/**
 * @author 张辉
 * @Description 自定义一个链表
 * 02版本：增加get
 * 03版本：增加remove
 * 04版本：增加插入节点
 * 05版本：增加泛型
 * @create 2020-04-08 11:54
 */
public class ZhLikedList05<E> {
    private Node first;
    private Node last;

    private int size;

    public void add(int index, E element) {

        Node newNode = new Node(element);
        Node temp = getNode(index);
        if (temp != null) {
            Node up = temp.previous;

            if (up != null) {
                up.next = newNode;
                newNode.previous = up;
            }

            if (temp != null) {
                newNode.next = temp;
                temp.previous = newNode;
            }
            if (index == 0) {
                first = newNode;
            }

            if (index == size - 1) {
                last = temp;
            }
        }
        size++;
    }


    public void remove(int index) {
        Node temp = getNode(index);

        if (temp != null) {
            Node up = temp.previous;
            Node dowm = temp.next;
            if (up != null) {
                up.next = dowm;
            }
            if (dowm != null) {
                dowm.previous = up;
            }

            // 下面这俩是将删除的元素是开头或者末尾的时候的首尾指针进行变化
            if (index == 0) {
                first = dowm;
            }
            if (index == size - 1) {
                last = up;
            }
            size--;
        }
    }


    public E get(int index) {
        Node temp = getNode(index);

        return temp != null ? (E) temp.element : null;
    }

    private void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引数字不合法：" + index);
        }
    }

    private Node getNode(int index) {
        checkRange(index);
        Node temp = null;
        if (index <= (size >> 1)) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i++) {
                temp = temp.previous;
            }
        }
        return temp;
    }


    public void add(E element) {
        Node node = new Node(element);
        if (first == null) {

            //node.previous = null;
            //node.next = null;

            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;

            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ZhLikedList05<String> list = new ZhLikedList05<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println(list);
        list.add(2, "dd");
        System.out.println(list);
        list.add(3, "ee");
        System.out.println(list);
        System.out.println(list.get(2));
        Vector ve;
    }
}
