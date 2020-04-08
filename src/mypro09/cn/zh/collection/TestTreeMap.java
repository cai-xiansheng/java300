package mypro09.cn.zh.collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author 张辉
 * @Description 测试TreeMap的使用
 * @create 2020-04-08 23:51
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> treemap1 = new TreeMap<>();
        treemap1.put(20, "aa");
        treemap1.put(40, "bb");
        treemap1.put(50, "cc");
        treemap1.put(60, "dd");

        // 按照key递增的方式排序
        for (Integer key : treemap1.keySet()) {
            System.out.println(key + "---" + treemap1.get(key));
        }

        Map<Emp,String> treemap2 = new TreeMap<>();
        treemap2.put(new Emp(100,"zs",50000),"zs");
        treemap2.put(new Emp(101,"zq",5000),"zq");
        treemap2.put(new Emp(102,"zw",500),"zw");

        for (Emp key:treemap2.keySet()) {
            System.out.println(key + "---" + treemap2.get(key));
        }
    }
}


class Emp implements Comparable<Emp>{
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Emp o) {
        if (this.salary > o.salary) {
            return 1;
        }else if (this.salary < o.salary) {
            return -1;
        }else {
            if (this.id > o.id) {
                return 1;
            }else if (this.id < o.id){
                return -1;
            }else{
                return 0;
            }
        }
    }
}