package mypro10.cn.zh.io;

import java.io.File;

/**
 * @author 张辉
 * @Description 递归打印子孙级目录和文件的名称
 * @create 2020-04-19 22:26
 */
public class DirDemo04 {
    public static void main(String[] args) {
        File src = new File("F:/IDEA_project/Java300");
        printName(src,0);
    }

    public static void printName(File src,int deep){
        // 控制前面层次
        for (int i = 0; i < deep; i++) {
            System.out.print("-");
        }
        System.out.println(src.getName());
        if (null == src || !src.exists()) {
            return;
        }else if (src.isDirectory()) {
            // 目录
            for (File s:src.listFiles()) {
                printName(s,deep+1);
            }
        }

    }
}
