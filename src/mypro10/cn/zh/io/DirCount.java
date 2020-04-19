package mypro10.cn.zh.io;

import java.io.File;

/**
 * @author 张辉
 * @Description 使用面向对象：统计文件夹的大小
 * @create 2020-04-19 22:42
 */
public class DirCount {
    private long len;

    private String path;

    private File src;

    public DirCount() {

    }

    public DirCount(String path) {
        this.path = path;
        this.src = new File(path);
        count(src);
    }

    public void setPath(String path) {
        this.path = path;
        this.src = new File(path);
        count(src);
    }


    public static void main(String[] args) {
        DirCount src = new DirCount("F:/IDEA_project/Java300");
        System.out.println(src.getLen());
        src = new DirCount("F:/IDEA_project/Java300/src");
        System.out.println(src.getLen());
    }

    public long getLen() {
        return len;
    }

    private void count(File src) {
        // 统计大小
        if (null != src && src.exists()) {
            if (src.isFile()) {
                // 大小
                len += src.length();
            } else {
                // 子孙级
                for (File s : src.listFiles()) {
                    count(s);
                }
            }
        }

    }
}
