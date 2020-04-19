package mypro10.cn.zh.io;

import java.awt.*;
import java.io.File;

/**
 * @author 张辉
 * @Description IO 流的路径
 * @create 2020-04-19 20:34
 */
public class PathDemo01 {
    public static void main(String[] args) {
        String path = "C:\\Users\\张辉\\Desktop\\th.jpg";

        System.out.println(File.separator);

        // 建议：
        // 1. 斜杠拼接
        path = "C:/Users/张辉/Desktop/th.jpg";
        System.out.println(path);
        // 2. 常量拼接 File.separator
        path = "C:" + File.separator+ "Users" + File.separator+ "张辉"+File.separator+"Desktop"+File.separator+"th.jpg";
        System.out.println(path);
    }
}
