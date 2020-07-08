package 测试类加载器;

import java.io.*;

/**
 * @author 张辉
 * @Description 自定义文件系统类加载器
 * @create 2020-07-08 11:29
 */
public class FileSystemClassLoader extends ClassLoader {

    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> c = findLoadedClass(name);

        // 应该要先查询有没有架子过这个类，如果已经加载，则直接返回加载好的类，如果没有，则加载新的类。
        if (c != null) {
            return c;
        } else {

            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name); // 委派给父类加载
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (c != null) {
                return c;
            } else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    c = defineClass(name, classData, 0, classData.length);
                }
            }

        }
        return c;

    }

    private byte[] getClassData(String className) {
        String path = rootDir + "/" + className.replace('.', '/') + ".class";

        //IOutils，可以使用它及那个流中的数据转成字节数组
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp = is.read(buffer)) != -1) {
                baos.write(buffer, 0, temp);
            }
            return baos.toByteArray();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loader = new FileSystemClassLoader("C:/myjava");

        Class<?> c = loader.loadClass("HelloWorld");

    }
}
