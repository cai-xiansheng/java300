package mypro10.cn.zh.io;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

/**
 * @author 张辉
 * @Description 创建目录
 * 1. mkdir():确保上级目录存在，不存在创建失败
 * 2. mkdirs():上级目录可以不存在，不存在一同来创建
 * @create 2020-04-19 21:57
 */
public class DirDemo01 {
    public static void main(String[] args) throws IOException {
        File dir = new File("F:/IDEA_project/Java300/dir/test");
        // 创建目录 mkdirs()
        boolean flag = dir.mkdirs();
        System.out.println(flag);

        // 创建目录 mkdir()
        dir = new File("F:/IDEA_project/Java300/dir/test2");
        flag = dir.mkdir();
        System.out.println(flag);

        // 创建文件

        dir = new File("F:/IDEA_project/Java300/dir/test0");
        flag = dir.createNewFile();
        System.out.println(flag);

    }
}
