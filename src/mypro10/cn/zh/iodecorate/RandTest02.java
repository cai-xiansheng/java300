package mypro10.cn.zh.iodecorate;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 张辉
 * @Description 随机流 RandomAccessFile
 * @create 2020-05-05 6:51
 */
public class RandTest02 {
    public static void main(String[] args) throws IOException {
        // 分多少块
        File src = new File("src/playgame/cn/zh/game/myGameFrame.java");
        // 总长度
        long len = src.length();
        // 每块大小
        int blockSize = 1024;
        // 块数：多少块
        int size = (int) Math.ceil(len * 1.0 / blockSize);
        System.out.println(size);

        // 起始位置和实际大小
        int beginPos = 0;
        int actualSize = (int) (blockSize > len ? len : blockSize);
        for (int i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size - 1) {
                // 最后一块
                actualSize = (int) len;
            } else {
                // 其他情况
                actualSize = blockSize;
                len -= actualSize;
                // 剩余量
            }
            System.out.println(i + "-->" + beginPos + "-->" + actualSize);
            split(i,beginPos,actualSize);
        }


    }

    /**
     * 指定第i块的起始位置和实际长度
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    public static void split(int i,int beginPos ,int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("src/playgame/cn/zh/game/myGameFrame.java"),"r");
        RandomAccessFile raf2 = new RandomAccessFile(new File("src/playgame/cn/zh/game/myGameFrame.java"),"rw");
        // 随机读取
        raf.seek(beginPos);
        // 读取
        byte[] flush = new byte[1024];
        // 缓冲容器
        int len = -1;
        // 接收长度

        while((len = raf.read(flush))!=-1){
            if (actualSize>len){
                // 获取本次读取的所有内容
                System.out.println(new String(flush,0,len));
                actualSize -= len;
            }else{
                System.out.println(new String(flush,0,len));
            }
        }
    }
}
