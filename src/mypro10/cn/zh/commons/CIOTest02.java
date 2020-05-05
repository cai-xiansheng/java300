package mypro10.cn.zh.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * @author 张辉
 * @Description
 * @create 2020-05-05 8:58
 */
public class CIOTest02 {
    public static void main(String[] args) {
        Collection<File> files =  FileUtils.listFiles(new File("src"),
                EmptyFileFilter.NOT_EMPTY, null);
        for (File file:files){
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("____________");
        files =  FileUtils.listFiles(new File("src"),
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"),EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
        for (File file:files){
            System.out.println(file.getAbsolutePath());
        }
    }
}
