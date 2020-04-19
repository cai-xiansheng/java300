package mypro09.cn.zh.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author 张辉
 * @Description 测试TreeSet;熟悉Comparable接口，可以参考TreeMap的课
 * @create 2020-04-19 11:30
 */
public class TestTreeSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(300);
        set.add(200);
        set.add(600);

        // 按照元素递增的方式排好序
        for (Integer m:set) {
            System.out.println(m);
        }

        Set<Emp2> set2 = new TreeSet<>();
        set2.add(new Emp2(100,"zs",50000));
        set2.add(new Emp2(103,"ze",40000));
        set2.add(new Emp2(102,"zd",70000));

        for (Emp2 m:set2) {
            System.out.println(m);
        }
    }
}

class Emp2 implements Comparable<Emp2>{
    int id;
    String name;
    double salary;

    public Emp2(int id, String name, double salary) {
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
    public int compareTo(Emp2 o) {
        // 负数：小于，0：等于，正数：大于
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
