package mypro05.cn.zh.array;

/**
 * @author 张辉
 * @Description 测试数组的拷贝
 * @create 2020-04-06 17:32
 */
public class TestArrayCopy {
    public static void main(String[] args) {
//        testBasicCopy2();
        String[] str = {"ali", "jd", "sxt", "tencent", "baidu"};
//        moveElement(str, 2);
//        extendRange(str);
        insert(str, "wo", 2);
    }

    public static void testBasicCopy() {
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        String[] s2 = new String[10];
        System.arraycopy(s1, 2, s2, 6, 3);
        for (int i = 0; i < s2.length; i++) {
            System.out.println(i + " " + s2[i]);
        }
    }

    public static void testBasicCopy2() {
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        String[] s2 = new String[10];
        System.arraycopy(s1, 3, s1, 2, 2);
        s1[s1.length - 1] = null;
        for (int i = 0; i < s1.length; i++) {
            System.out.println(i + " " + s1[i]);
        }
    }

    /**
     * 删除指定位置的字符
     *
     * @param s
     * @param index
     * @return String[]
     */
    public static String[] moveElement(String[] s, int index) {
        System.arraycopy(s, index + 1, s, index, s.length - index - 1);
        s[s.length - 1] = null;
        for (int i = 0; i < s.length; i++) {
            System.out.println(i + " " + s[i]);
        }
        return s;
    }

    /**
     * 数组的扩容（本质上是：先定义一个更大的数组，然后将原数组内容原封不动的拷贝到新数组中去）
     *
     * @param s1
     * @return new String[]
     */
    public static String[] extendRange(String[] s1) {
        String[] s2 = new String[s1.length + 10];
        System.arraycopy(s1, 0, s2, 0, s1.length);
        for (String temp : s2) {
            System.out.println(temp);
        }
        return s2;
    }

    /**
     * 在指定数组中指定位置插入元素
     *
     * @param s1 原数组
     * @param s 要插入的元素
     * @param i 插入的位置
     * @return new String[]
     */
    public static String[] insert(String[] s1, String s, int i) {
        String[] s2 = new String[1 + s1.length];
        System.arraycopy(s1, 0, s2, 0, s1.length);
        System.arraycopy(s2, i, s2, i + 1, s1.length - i);
        s2[i] = s;
        for (String temp : s2) {
            System.out.println(temp);
        }
        return s2;
    }
}
