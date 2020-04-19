package mypro10.cn.zh.io;

import java.io.File;

/**
 * @author 张辉
 * @Description 构建文件对象 相对路径与绝对路径（存在盘符：绝对路径；不存在盘符：相对路径）
 * @create 2020-04-19 20:42
 */
public class FileDemo02 {
    public static void main(String[] args) {
        String path = "F:/IDEA_project/Java300/src/mypro10/cn/zh/io/FileDemo01.java";

        // 绝对路径
        File src = new File(path);

        System.out.println(src.getAbsolutePath());

        // 项目相对路径
        System.out.println(System.getProperty("user.dir")
        );
        src = new File("FileDemo01.java");
        System.out.println(src.getAbsolutePath());


        // 构建一个不存在的文件
        src = new File("aaa/FileDemo01.java");
        System.out.println(src.getAbsolutePath());



    }
}
