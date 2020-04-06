package MyPro04.cn.hz.oo2;

/*
* super 永远位于构造器的第一个位置
* super 回溯到 Object 之后才会向下执行*/
public class TestSuper02 {
    public static void main(String[] args) {
        System.out.println("开始创建一个ChildClass对象......");
        new ChildClass2();
    }
}

class FatherClass2 {
    public FatherClass2() {
        System.out.println("创建FatherClass");
    }
}

class ChildClass2 extends FatherClass2 {
    public ChildClass2() {
        super();
        System.out.println("创建ChildClass");
    }
}