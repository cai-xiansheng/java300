package mypro10.cn.zh.iodecorate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 张辉
 * @Description 随机读取和写入流 RandomAccessFile
 * @create 2020-05-04 17:17
 */
public class RandTest01 {
    public static void main(String[] args) throws IOException {
       // 分多少块
        File src = new File("src/playgame/cn/zh/game/myGameFrame.java");
        // 总长度
        long len = src.length();
        // 每块大小
        int blockSize = 1024;
        // 多少块
        int size = (int) Math.ceil(len*1.0 / blockSize);
        System.out.println(size);

    }

    public static void test2() throws IOException {
        // 分开思想
        RandomAccessFile raf = new RandomAccessFile(new File("src/playgame/cn/zh/game/myGameFrame.java"),"r");
        int beginPos = 2 + 1026;
        int actualSize = 1026;
        // 随机读取
        raf.seek(beginPos);
        // 读取
        byte[] flush = new byte[1024];
        // 缓冲容器
        int len = -1;
        // 接收长度
        while((len = raf.read(flush))!=-1){
            System.out.println(new String(flush,0,len));
            if (actualSize>len){
                System.out.println(new String(flush,0,len));
                actualSize -= len;
            }else{
                System.out.println(new String(flush,0,actualSize));
                break;
            }
        }

        raf.close();
    }
    public static void test1() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("src/playgame/cn/zh/game/myGameFrame.java"),"r");
        // 随机读取
        raf.seek(2);
        // 读取
        byte[] flush = new byte[1024];
        // 缓冲容器
        int len = -1;
        // 接收长度
        while((len = raf.read(flush))!=-1){
            System.out.println(new String(flush,0,len));
        }

        raf.close();
    }
}
