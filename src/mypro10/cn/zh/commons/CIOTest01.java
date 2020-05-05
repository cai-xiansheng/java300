package mypro10.cn.zh.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @author 张辉
 * @Description 文件夹的大小
 * @create 2020-05-05 8:27
 */
public class CIOTest01 {
    public static void main(String[] args) {
        // 文件的大小
        long len = FileUtils.sizeOf(new File("src/mypro10/cn/zh/commons/CIOTest01.java"));
        System.out.println(len);
        // 目录的大小
        len = FileUtils.sizeOf(new File("F:/IDEA_project/Java300/src"));
        System.out.println(len);
    }
}
