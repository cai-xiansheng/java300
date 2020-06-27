package com.zh.webserver02;


import com.zh.webserver02.WebContext;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author 张辉
 * @Description
 * @create 2020-06-08 10:22
 */
public class WebApp {
    private static com.zh.webserver02.WebContext webContext;

    static {
        try {
//SAX解析
            //1. 获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //2. 从解析工厂获取解析器
            SAXParser parse = factory.newSAXParser();
            //3. 编写处理器
            //4. 加载文档Document注册处理器
            WebHandler handler = new WebHandler();
            //5. 解析
            parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/zh/webserver02/web.xml"), handler);

            // 获取数据

            webContext = new WebContext(handler.getEntities(), handler.getMappings());
        } catch (Exception e) {
            System.out.println("解析配置文件错误！");
        }
    }

    /**
     * 通过url获取配置文件的servlet
     * @param url
     * @return
     */
    public static Servlet getServletFromUrl(String url) {

        // 假设你输入了  /login
        String className = webContext.getClz("/" + url);
        Class clz = null;
        try {
            clz = Class.forName(className);
            com.zh.webserver02.Servlet servlet = (com.zh.webserver02.Servlet)clz.getConstructor().newInstance();
            // 反射
            return servlet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
