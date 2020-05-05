package mypro10.cn.zh.iodecorate;

import javax.sound.midi.Sequence;
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author 张辉
 * @Description 面向对象思想封装 分割
 * @create 2020-05-05 6:51
 */
public class SplitFile {
    /**
     * 源头
     * 目的地（文件夹）
     * 所有分割后的文件存储路径
     * 每块的大小
     * 块数
     */

    private File src;
    private String destDir;
    private List<String> destPaths;
    private int blockSize;
    private int size;

    public SplitFile() {

    }

    public SplitFile(String srcPath, String destDir) {
        this(srcPath,destDir,1024);
    }

    public SplitFile(String srcPath, String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<String>();
        init();
    }

    public void init() {
        // 总长度
        long len = this.src.length();
        // 块数
        this.size = (int) (Math.ceil(len * 1.0) / this.blockSize);
        // 路径
        for (int i = 0; i < this.size; i++) {
            this.destPaths.add(this.destDir +"/"+ i + "-" + this.src.getName());
        }

    }

    /**
     * 分割
     * 1. 计算每一块的起始位置和大小
     *
     * @throws IOException
     */
    private void split() throws IOException {
        // 总长度
        long len = this.src.length();
        // 起始位置和实际大小
        int beginPos = 0;
        int actualSize = (int) (blockSize > len ? len : blockSize);
        for (int i = 0; i < this.size; i++) {
            beginPos = i * this.blockSize;
            if (i == this.size - 1) {
                // 最后一块
                actualSize = (int) len;
            } else {
                actualSize = this.blockSize;
                len -= actualSize;
            }
            this.splitDetail(i, beginPos, actualSize);
        }

    }

    /**
     * 指定第i块的起始位置和实际长度
     *
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    public void splitDetail(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src, "r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i), "rw");
        // 随机读取
        raf.seek(beginPos);
        // 读取(分段读取，也就是操作)
        byte[] flush = new byte[1024];
        // 缓冲容器
        int len = -1;
        // 接收长度

        while ((len = raf.read(flush)) != -1) {
            if (actualSize > len) {
                // 获取本次读取的所有内容
                raf2.write(flush,0,len);
                actualSize -= len;
            } else {
                raf2.write(flush,0,actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();
    }


    /**
     * 文件的合并
     * @param destPath
     * @throws IOException
     */
    public void merge(String destPath) throws IOException {
        // 输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
        Vector<InputStream> vi = new Vector<InputStream>();
        SequenceInputStream sis = null;
        // 输入流
        for (int i = 0; i < this.destPaths.size(); i++) {
            vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
        }
        sis = new SequenceInputStream(vi.elements());
        // 拷贝
        // 3.操作
        byte[] flush = new byte[1024];
        // 缓冲容器
        int len = -1;
        // 接收长度
        while ((len = sis.read(flush))!=-1){
            os.write(flush,0,len);
        }
        os.flush();
        os.close();
    }

    public static void main(String[] args) throws IOException {

        SplitFile sf = new SplitFile("F:/IDEA_project/Java300/src/mypro10/cn/zh/iodecorate/SplitFile.java", "dest" );
        sf.split();
        sf.merge("aaa.java");
    }
}
