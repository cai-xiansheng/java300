package mypro11.cn.zh.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 张辉
 * @Description 下载图片
 * @create 2020-05-08 8:12
 */
public class WebDownloader {
    public void download(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("不合法的url");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败");
        }
    }
}
