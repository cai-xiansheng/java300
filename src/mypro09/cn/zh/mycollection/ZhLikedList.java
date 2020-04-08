package mypro09.cn.zh.mycollection;

/**
 * @author 张辉
 * @Description 自定义一个链表
 * @create 2020-04-08 11:54
 */
public class ZhLikedList {
    private Node first;
    private Node last;

    private int size;

    public void add(Object obj) {
        Node node = new Node(obj);
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
        ZhLikedList list = new ZhLikedList();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println(list);
    }
}
