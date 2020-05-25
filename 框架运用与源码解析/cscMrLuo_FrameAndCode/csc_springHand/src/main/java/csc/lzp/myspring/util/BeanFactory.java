package csc.lzp.myspring.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Discription: 两个bean的顺序发生改变的情况没有去考虑
 * @Author: luozhipeng
 **/
public class BeanFactory {
    //用来存bean的容器
    Map<String, Object> map = new HashMap<String, Object>();

    public BeanFactory(String xml) {
        parseXml(xml);
    }

    /**
     * @param xml spring.xml的配置文件
     */
    public void parseXml(String xml) {
        File file = new File(xml);
        SAXReader reader = new SAXReader();

        Document doc = null;
        try {
            Document document = reader.read(file);
            Element rootElement = document.getRootElement();
            //List<Element> allChild = rootElement.elements();
            for (Iterator<Element> itFirst = rootElement.elementIterator(); itFirst.hasNext(); ) {
                //实例化对象
                Element elementFirstChild = itFirst.next();
                //id属性
                Attribute attributeId = elementFirstChild.attribute("id");
                String beanName = attributeId.getValue();
                //class属性
                Attribute attributeClass = elementFirstChild.attribute("class");
                String clazzName = attributeClass.getValue();
                //通过反射拿到一个实例对象
                Class clazz = Class.forName(clazzName);
                Object object = clazz.newInstance();

                //维护依赖关系
                //看这个对象有没有依赖,判断是否有属性

                for (Iterator<Element> itSecond = rootElement.elementIterator(); itSecond.hasNext(); ) {

                    Element elementSecondChild = itSecond.next();
                    if (elementSecondChild.getName().equals("property")) {//setter注入的方式

                        String refValue = elementSecondChild.attribute("ref").getValue();
                        Object target = map.get(refValue);
                        String nameValue = elementSecondChild.attribute("name").getValue();

                        Field field = clazz.getDeclaredField(nameValue);
                        field.setAccessible(true);
                        field.set(object, target);
                    } else if (false) {//构造函数注入的方式

                    } else {
                        System.out.println("你的配置文件不符合要求");
                    }
                }
                map.put(beanName, object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }

    /**
     * @param beanName 你需要拿bean的名称
     * @return
     */
    public Object getBean(String beanName) {
        return map.get(beanName);
    }
}
