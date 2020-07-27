package gof23.composite;

/**
 * @author 张辉
 * @Description 组合模式
 * @create 2020-07-27 17:11
 */
public interface Component {
    void operation();
}

// 叶子组件
interface Leaf extends Component {

}

// 容器组件
interface Composite extends Component {
    void add(Component c);
    void remove(Component c);
    void getChild(Component c);
}