package mypro11.cn.zh.thread;

/**
 * @author 张辉
 * @Description
 * @create 2020-05-08 8:17
 */
public class IDownloader implements Runnable {
    private String url;
    private String name;

    public IDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        IDownloader td1 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588907409428&di=b08ec32df49d24e0153d046b5e37e86e&imgtype=0&src=http%3A%2F%2Fqimg.hxnews.com%2F2018%2F0611%2F1528676232318.jpg","火箭熊.jpg");
        IDownloader td2 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588907409428&di=315902600665b2854ac20e3a60a8ec2a&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0105d15724c5886ac725381222c109.jpg%402o.jpg","蜘蛛侠.jpg");
        IDownloader td3 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588907837238&di=5519b9b715f0276bb29fc1e07497db54&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01850455450dc50000019ae92d459c.jpg%401280w_1l_2o_100sh.jpg","蜘蛛侠02.jpg");

        new Thread(td1).start();
        new Thread(td2).start();
        new Thread(td3).start();

    }
}
