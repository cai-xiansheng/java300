package com.zh.webserver02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张辉
 * @Description
 * @create 2020-06-07 13:29
 */
public class WebContext {
    private List<Entity> entities = null;
    private List<Mapping> mappings = null;

    // key --> servlet-name  value --> servlet-class
    private Map<String, String> entityMap = new HashMap<>();
    // key --> url-pattern value --> servlet-name
    private Map<String, String> mappingMap = new HashMap<>();

    public WebContext(List<Entity> entities, List<Mapping> mappings) {
        this.entities = entities;
        this.mappings = mappings;

        // 将entities的List转成了map
        for (Entity entity : entities) {
            entityMap.put(entity.getName(), entity.getClz());
        }

        // 将mappings的List转成了map
        for (Mapping mapping : mappings) {
            for (String pattern : mapping.getPatterns()) {
                mappingMap.put(pattern, mapping.getName());
            }
        }
    }

    /**
     * 通过URL的路径找到了对应的class
     * @param pattern
     * @return
     */
    public String getClz(String pattern) {
        String name = mappingMap.get(pattern);
        return entityMap.get(name);
    }
}
