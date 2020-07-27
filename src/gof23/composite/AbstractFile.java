package gof23.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 17:15
 */
public interface AbstractFile {
    void killVirus(); // 杀毒
}

class ImageFile implements AbstractFile {

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("ImageFile.killVirus" + name);
    }
}


class TextFile implements AbstractFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("TextFile.killVirus" + name);
    }
}


class VideoFile implements AbstractFile {

    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("VideoFile.killVirus" + name);
    }
}


class Folder implements AbstractFile {
    private String name;

    // 定义容器，用来存放本容器构建下的子节点
    private List<AbstractFile> list = new ArrayList<AbstractFile>();

    public Folder(String name) {
        this.name = name;
    }

    public void add (AbstractFile file) {
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChiled (int index) {
        return list.get(index);
    }
    @Override
    public void killVirus() {
        System.out.println("Folder.killVirus(文件夹)");
        for (AbstractFile file:list) {
            file.killVirus();
        }
    }
}