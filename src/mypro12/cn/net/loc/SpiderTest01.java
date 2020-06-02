package mypro12.cn.net.loc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author 张辉
 * @Description 网络爬虫原理
 * @create 2020-05-31 11:01
 */
public class SpiderTest01 {
    public static void main(String[] args) throws Exception {
        // 获取URL
        //URL url = new URL("https://www.jd.com");
        URL url = new URL("https://www.dianping.com");
        // 下载资源
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println(msg);
        }
        br.close();
        // 分析
        // 筛选
    }
}
