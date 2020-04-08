package mypro09.cn.zh.mycollection;

/**
 * @author 张辉
 * @Description 自定义 HashMap
 * 实现put方法增加键值对，并解决了键重复的时候覆盖相应的节点
 * 02版本：重写toString()
 * 03版本：实现get方法，根据键对象，获得值对象
 * @create 2020-04-08 21:50
 */
public class ZhHashMap03 {

    Node2[] table;
    /**
     * table核心数组,位桶数组。bucket array
     * size 存放了多少个键值对
     */
    int size;

    public  Object get(Object key) {
        int hash = myHash(key.hashCode(),table.length);
        Object value = null;
        if (table[hash] != null) {
            Node2 temp = table[hash];

            while (temp!=null) {
                if (temp.key.equals(key)) {
                    // 如果相等，则说明找到了键值对，返回相应的value
                    value = temp.value;
                    break;
                }else {
                    temp = temp.next;
                }
            }
        }
        return value;
    }

    public ZhHashMap03() {
        table = new Node2[16];
        // 长度定义为2的整数幂
    }

    public void put(Object key, Object value) {

        // 如果要完善，还需要考虑数组据扩容的处理

        // 定义了新的节点对象
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;


        Node2 temp = table[newNode.hash];

        Node2 iterLast = null;
        // 正在遍历的最后一个元素
        boolean keyRepeat = false;
        if (temp == null) {
            // 此处数组元素为空，则直接将新节点放进去
            table[newNode.hash] = newNode;
            size++;
        } else {

            // 此处数组元素不为空，则遍历对应链表。。
            while (temp != null) {
                if (temp.key.equals(key)) {
                    // 判断Key如果重复，则覆盖
                    temp.value = value;
                    // 只是覆盖value即可，其他的值（hash,key,next）不变
                    keyRepeat = true;
                    break;
                } else {
                    // key不重复，则遍历下一个。
                    iterLast = temp;
                    temp = temp.next;
                }

            }

            if (!keyRepeat) {
                iterLast.next = newNode;
                size++;
            }
        }

    }

    public int myHash(int v, int length) {
        //System.out.println("Hash is muHash&:" + (v & (length - 1)));
        // 直接位运算，效率高。取模需要减一
        //System.out.println("Hash is muHash%:" + (v % (length)));
        // 取模运算，效率低。取余不需要减一
        return v & (length-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        // 遍历数组
        for (int i = 0; i < table.length; i++) {
            Node2 temp = table[i];
            // 遍历链表
            while (temp != null) {
                sb.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public static void main(String[] args) {
        ZhHashMap03 m = new ZhHashMap03();
        m.put(10, "aa");
        m.put(20, "bb");
        m.put(30, "cc");
        m.put(40, "dd");
        m.put(20, "sss");
        m.put(53, "zs");
        m.put(69, "qs");
        m.put(85, "as");

        System.out.println(m);
        System.out.println(m.size);
    }

}


