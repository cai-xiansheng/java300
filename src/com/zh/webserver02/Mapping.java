package com.zh.webserver02;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 张辉
 * @Description
 *     <servlet-mapping>
 *         <servlet-name>login</servlet-name>
 *         <url-pattern>/login</url-pattern>
 *         <url-pattern>/g</url-pattern>
 *     </servlet-mapping>
 * @create 2020-06-07 12:58
 */
public class Mapping {
    private String name;
    private Set<String> patterns;

    public Mapping() {
        patterns = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }

    public void addPattern(String pattern) {
        this.patterns.add(pattern);
    }
}
