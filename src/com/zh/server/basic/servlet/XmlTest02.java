package com.zh.server.basic.servlet;

import com.zh.server.basic.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张辉
 * @Description 熟悉SAX解析流程
 * @create 2020-06-07 11:35
 */
public class XmlTest02 {
    public static void main(String[] args) throws Exception {
        //SAX解析
        //1. 获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2. 从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        //3. 编写处理器
        //4. 加载文档Document注册处理器
        WebHandler handler = new WebHandler();
        //5. 解析
        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/zh/server/basic/servlet/web.xml"), handler);

        // 获取数据
        WebContext context = new WebContext(handler.getEntities(), handler.getMappings());

        // 假设你输入了  /login
        String className = context.getClz("/reg");
        Class clz =  Class.forName(className);
        Servlet servlet = (Servlet)clz.getConstructor().newInstance();
        System.out.println(servlet);
        servlet.servive();
    }
}

class WebHandler extends DefaultHandler {
    private List<Entity> entities;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;
    private String tag; // 存储操作标签
    private boolean isMapping = false;

    @Override
    public void startDocument() throws SAXException {
        entities = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName != null) {
            tag = qName;// 存储标签名
            if (tag.equals("servlet")) {
                entity = new Entity();
                isMapping = false;
            } else if (tag.equals("servlet-mapping")) {
                mapping = new Mapping();
                isMapping = true;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (tag != null) { // 处理了空的问题
            if (isMapping) {
                // 操作servlet-mapping
                if (tag.equals("servlet-name")) {
                    mapping.setName(contents);
                } else if (tag.equals("url-pattern")) {
                    mapping.addPattern(contents);
                }
            } else {
                // 操作servlet
                if (tag.equals("servlet-name")) {
                    entity.setName(contents);
                } else if (tag.equals("servlet-class")) {
                    entity.setClz(contents);
                }
            }


        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName != null) {
            if (qName.equals("servlet")) {
                entities.add(entity);
            } else if (qName.equals("servlet-mapping")) {
                mappings.add(mapping);
            }
        }
        tag = null; // tag丢弃
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

}