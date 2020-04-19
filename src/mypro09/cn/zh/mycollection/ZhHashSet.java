package mypro09.cn.zh.mycollection;

import java.util.HashMap;

/**
 * @author 张辉
 * @Description HashSet 实现
 * @create 2020-04-19 11:16
 */
public class ZhHashSet {

    HashMap map;

    private static final Object PRESENT = new Object();

    public ZhHashSet() {
        map = new HashMap();
    }

    public int size() {
        return map.size();
    }

    public void add(Object o) {
        map.put(o, PRESENT);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (Object key:map.keySet()) {
            sb.append(key+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ZhHashSet set = new ZhHashSet();
        set.add("aa");
        set.add("bb");
        set.add("cc");

        System.out.println(set);

    }

}
