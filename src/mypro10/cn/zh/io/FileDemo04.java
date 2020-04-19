package mypro10.cn.zh.io;

import java.io.File;

/**
 * @author 张辉
 * @Description 获取文件的状态
 * @create 2020-04-19 21:25
 */
public class FileDemo04 {
    /**
     * 1. 不存在
     * 2. 存在
     *  文件：isFile
     *  文件夹：isDirectory
     */
    public static void main(String[] args) {
        File src = new File("src/笔记.md");
        System.out.println("是否存在：" + src.exists());
        System.out.println("是否文件：" + src.isFile());
        System.out.println("是否文件夹：" + src.isDirectory());

        src = new File("笔记.md");
        System.out.println("是否存在：" + src.exists());
        System.out.println("是否文件：" + src.isFile());
        System.out.println("是否文件夹：" + src.isDirectory());

        src = new File("F:\\IDEA_project\\Java300\\src");
        System.out.println("是否存在：" + src.exists());
        System.out.println("是否文件：" + src.isFile());
        System.out.println("是否文件夹：" + src.isDirectory());

        src = new File("xxx");
        // 文件状态
        if (null == src || !src.exists()) {
            System.out.println("文件不存在！");
        }else{
            if (src.isFile()) {
                System.out.println("文件操作");
            }else{
                System.out.println("文件夹操作");
            }
        }
    }
}
