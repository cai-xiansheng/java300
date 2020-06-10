package com.zh.server.basic;

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
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX解析
        //1. 获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2. 从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        //3. 编写处理器
        //4. 加载文档Document注册处理器
        PersonHandler handler = new PersonHandler();
        //5. 解析
        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/zh/server/basic/p.xml"), handler);

        // 获取数据
        List<Person> persons = handler.getPersons();
        for(Person p:persons) {
            System.out.println(p.getName() + "-->" + p.getAge());
        }
    }
}

class PersonHandler extends DefaultHandler {
    private List<Person> persons;
    private Person person;
    private String tag; // 存储操作标签

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName != null) {
            tag = qName;// 存储标签名
            if (tag.equals("person")) {
                person = new Person();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (tag != null) { // 处理了空的问题
            if (tag.equals("name")) {
                person.setName(contents);
            } else if (tag.equals("age")) {
                if (contents.length() > 0) {
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName != null) {
            if (qName.equals("person")) {
                persons.add(person);
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
    }
}