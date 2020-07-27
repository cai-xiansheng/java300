package gof23.flyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张辉
 * @Description
 * @create 2020-07-27 21:12
 */
public class ChessFlyWeightFactory {
    // 享元池
    private static Map<String, ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color) {
        if (map.get(color) != null) {
            return map.get(color);
        } else {
            ChessFlyWeight cfw = new ConcreteChess(color);
            map.put(color, cfw);
            return cfw;
        }
    }
}
