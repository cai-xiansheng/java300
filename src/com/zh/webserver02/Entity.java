package com.zh.webserver02;

/**
 * @author 张辉
 * @Description
 *     <servlet>
 *         <servlet-name>login</servlet-name>
 *         <servlet-class>com.zh.LoginServlet</servlet-class>
 *     </servlet>
 * @create 2020-06-07 12:54
 */
public class Entity {
    private String name;
    private String clz;

    public Entity() {

    }

    public Entity(String name, String clz) {
        this.name = name;
        this.clz = clz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }
}
