package mypro12.cn.net.loc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 张辉
 * @Description 网络爬虫原理 + 模拟浏览器
 * @create 2020-05-31 11:01
 */
public class SpiderTest02 {
    public static void main(String[] args) throws Exception {
        // 获取URL
        URL url = new URL("https://www.dianping.com");
        // 下载资源
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println(msg);
        }
        br.close();
        // 分析
        // 筛选
    }
}
