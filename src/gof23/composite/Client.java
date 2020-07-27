package gof23.composite;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 17:23
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile f2,f3,f4,f5,f6;
        Folder f1 = new Folder("我的收藏");
        f2 = new ImageFile("老高的大头像.jpg");
        f3 = new TextFile("hello.txt");
        f1.add(f2);
        f1.add(f3);
        f2.killVirus();
        f1.killVirus();
    }
}
