package mypro08.cn.zh.test;

import java.io.File;
import java.util.Date;

/**
 * @author 张辉
 * @Description 测试File类的基本用法
 * @create 2020-04-07 13:24
 */
public class TestFile {
    public static void main(String[] args) {
//        File f = new File("D:/a.txt");
        File f = new File("D:/bb.txt");
        System.out.println(f);
        f.renameTo(new File("D:/b.txt"));

        System.out.println(System.getProperty("user.dir"));


        File f2 = new File("d:/b.txt");
        System.out.println("File是否存在："+f2.exists());
        System.out.println("File是否是目录："+f2.isDirectory());
        System.out.println("File是否是文件："+f2.isFile());
        System.out.println("File最后修改时间："+new Date(f2.lastModified()));
        System.out.println("File的大小："+f2.length());
        System.out.println("File的文件名："+f2.getName());
        System.out.println("File的目录路径："+f2.getPath());
    }
}
