package mypro11.cn.zh.thread;

import java.util.concurrent.*;

/**
 * @author 张辉
 * @Description 了解创建线程的方式3(Callable)
 * @create 2020-05-08 8:17
 */
public class CDownloader implements Callable<Boolean> {
    private String url;
    private String name;

    public CDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception{
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        System.out.println(name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownloader cd1 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588907409428&di=b08ec32df49d24e0153d046b5e37e86e&imgtype=0&src=http%3A%2F%2Fqimg.hxnews.com%2F2018%2F0611%2F1528676232318.jpg","火箭熊.jpg");
        CDownloader cd2 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588907409428&di=315902600665b2854ac20e3a60a8ec2a&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0105d15724c5886ac725381222c109.jpg%402o.jpg","蜘蛛侠.jpg");
        CDownloader cd3 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588907837238&di=5519b9b715f0276bb29fc1e07497db54&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01850455450dc50000019ae92d459c.jpg%401280w_1l_2o_100sh.jpg","蜘蛛侠02.jpg");

        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> reslut1 = service.submit(cd1);
        Future<Boolean> reslut2 = service.submit(cd2);
        Future<Boolean> reslut3 = service.submit(cd3);
        // 获取结果
        boolean r1 = reslut1.get();
        boolean r2 = reslut2.get();
        boolean r3 = reslut3.get();
        System.out.println(r3);
        // 关闭服务
        service.shutdownNow();

    }
}
