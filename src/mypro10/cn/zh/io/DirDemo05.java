package mypro10.cn.zh.io;

import java.io.File;

/**
 * @author 张辉
 * @Description 获取文件夹的大小(字节)
 * @create 2020-04-19 22:26
 */
public class DirDemo05 {
    private static long len = 0;
    public static void main(String[] args) {
        File src = new File("F:/IDEA_project/Java300");
        count(src);
        System.out.println(len);
    }

    public static void count(File src){

        if (null != src && src.exists()) {
            if (src.isFile()) {
                // 大小
                len += src.length();
            }else {
                // 子孙级
                for (File s :src.listFiles()) {
                    count(s);
                }
            }
        }

    }
}
