package mypro10.cn.zh.iotest;

import java.io.*;

/**
 * @author 张辉
 * @Description 字节数组输出流
 * 1. 创建源:内部维护
 * 2. 选择流：不关联源
 * 3. 操作（写出内容）
 * 4. 释放资源：可以不用
 * <p>
 * 数据获取：toByteArray
 * @create 2020-04-25 18:13
 */
public class IOTest08 {
    public static void main(String[] args) {
        // 1. 创建流
        byte[] dest = null;
        // 2. 选择流(新增方法)
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            // 3. 操作
            String msg = "show me the code";
            byte[] datas = msg.getBytes();
            // 字符串到字节数组（编码）
            baos.write(datas, 0, datas.length);
            baos.flush();
            // 刷新，放置驻留

            dest = baos.toByteArray();
            System.out.println(dest.length + "-->" + new String(dest, 0, baos.size()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 释放资源
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
