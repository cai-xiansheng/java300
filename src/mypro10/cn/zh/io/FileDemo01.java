package mypro10.cn.zh.io;

import java.io.File;

/**
 * @author 张辉
 * @Description 构建文件对象
 * @create 2020-04-19 20:42
 */
public class FileDemo01 {
    public static void main(String[] args) {
        String path = "C:/Users/张辉/Desktop/th.jpg";

        // 1.构建File对象
        File src = new File(path);
        System.out.println(src.length());
        // length() 返回对象的大小

        // 2. 构建File对象
        src = new File("C:/Users/张辉/Desktop/","th.jpg");
        System.out.println(src.length());

        // 3.构建File对象
        src = new File(new File("C:/Users/张辉/Desktop/"),"th.jpg");
        System.out.println(src);
    }
}
