package mypro09.cn.zh.mycollection;

/**
 * @author 张辉
 * @Description Node 节点
 * @create 2020-04-08 11:55
 */
public class Node {
    Node previous;
    Node next;
    Object element;

    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }
}
