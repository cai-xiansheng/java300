package mypro10.cn.zh.io;

import java.io.File;

/**
 * @author 张辉
 * @Description 获取文件的名称和路径
 * @create 2020-04-19 21:15
 */
public class FileDemo03 {
    /**
     * getName()    ：文件名称
     * getPath()    ：相对路径
     * getAbsolutePath()    ：文件绝对路径
     * getParent()  ：父路径，上一个路径：如果存在就返回null
     */

    public static void main(String[] args) {
        File src = new File("F:/IDEA_project/Java300/笔记.md");
        // 基本信息
        System.out.println("名称：" + src.getName());
        System.out.println("路径：" + src.getPath());
        System.out.println("绝对路径：" + src.getAbsolutePath());
        System.out.println("父节点：" + src.getParent());
        System.out.println("父对象：" + src.getParentFile().getName());
    }
}
