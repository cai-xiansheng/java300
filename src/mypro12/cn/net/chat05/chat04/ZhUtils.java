package mypro12.cn.net.chat05.chat04;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author 张辉
 * @Description 释放资源----》工具类
 * @create 2020-06-02 22:02
 */
public class ZhUtils {
    public static void close(Closeable... targets) {
        for (Closeable target : targets) {
            try {
                if (target != null) {
                    target.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
