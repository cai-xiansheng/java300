package mypro10.cn.zh.iotest;

import java.io.*;

/**
 * @author 张辉
 * @Description 文件字节流的拷贝
 * @create 2020-05-05 22:07
 */
public class CopyUtilsByte {
    private File src;
    private File dest;
    private int size = 1024 * 10;

    public CopyUtilsByte(String src, String dest) {
        this.src = new File(src);
        this.dest = new File(dest);
    }

    public CopyUtilsByte(String src, String dest, int size) {
        this.src = new File(src);
        this.dest = new File(dest);
        this.size = size;
    }

    public CopyUtilsByte(File src, File dest) {
        this.src = src;
        this.dest = dest;
    }

    public CopyUtilsByte(File src, File dest, int size) {
        this.src = src;
        this.dest = dest;
        this.size = size;
    }

    private void copy() {
        try (InputStream is = new FileInputStream(src);
             OutputStream os = new FileOutputStream(dest);) {
            byte[] flush = new byte[this.size];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
