package gof23.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 23:02
 */
public class President implements Mediator {
    private Map<String,Department> map = new HashMap<>();

    @Override
    public void register(String dName, Department d) {
        map.put(dName, d);
    }

    @Override
    public void command(String dName) {
        map.get(dName).selfAction();
    }
}
