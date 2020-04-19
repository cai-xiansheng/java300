package mypro09.cn.zh.collection;

import java.util.*;

/**
 * @author 张辉
 * @Description 测试容器表格存储数据！
 * @create 2020-04-19 12:31
 */
public class TestStoreData {
    public static void main(String[] args) {

        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 1001);
        row1.put("name", "zs");
        row1.put("salary", 40000);
        row1.put("入职日期", "2020.8.10");

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 1002);
        row2.put("name", "zd");
        row2.put("salary", 30000);
        row2.put("入职日期", "2020.7.10");

        Map<String, Object> row3 = new HashMap<>();
        row3.put("id", 1003);
        row3.put("name", "ze");
        row3.put("salary", 50000);
        row3.put("入职日期", "2020.9.10");

        List<Map<String, Object>> table = new ArrayList<>();

        table.add(row1);
        table.add(row2);
        table.add(row3);


        for (Map<String, Object> row : table) {
            Set<String> keyset = row.keySet();
            for (String key : keyset) {
                System.out.print(key + ":" + row.get(key) + "\t");
            }
            System.out.println();
        }


    }
}
