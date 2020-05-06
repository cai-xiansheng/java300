package mypro10.cn.zh.iotest;

import java.io.*;

/**
 * @author 张辉
 * @Description 文件字符流
 * @create 2020-05-06 7:19
 */
public class CopyUtilsChar {
    private File src;
    private File dest;
    private int size = 1024;

    public CopyUtilsChar(String src, String dest) {
        this.src = new File(src);
        this.dest = new File(dest);
        Math s;
    }

    public CopyUtilsChar(String src, String dest, int size) {
        this.src = new File(src);
        this.dest = new File(dest);
        this.size = size;
    }

    public CopyUtilsChar(File src, File dest) {
        this.src = src;
        this.dest = dest;
    }

    public CopyUtilsChar(File src, File dest, int size) {
        this.src = src;
        this.dest = dest;
        this.size = size;
    }

    private void copy() {
        try (Reader reader = new FileReader(src);
             Writer writer = new FileWriter(dest)) {
            char[] flush = new char[size];
            int len = -1;
            while ((len = reader.read(flush)) != -1) {
                writer.write(flush, 0, len);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
