package mypro09.cn.zh.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张辉
 * @Description 测试泛型（generics） 容器(collection)
 * @create 2020-04-07 17:57
 */
public class TestGeneric {
    public static void main(String[] args) {
        MyCollection<String> mc = new MyCollection<>();
        mc.setObjs("zhanghui",0);

        String b = mc.getObjs(0);

        List list = new ArrayList();

        Map map = new HashMap();
    }
}

class MyCollection<E>{
    Object[] objs = new Object[5];

    public E getObjs(int index) {
        return (E) objs[index];
    }

    public void setObjs(E objs,int index) {
        this.objs[index] = objs;
    }
}
