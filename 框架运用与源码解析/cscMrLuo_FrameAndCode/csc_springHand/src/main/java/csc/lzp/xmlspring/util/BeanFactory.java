package csc.lzp.xmlspring.util;

import csc.lzp.xmlspring.exception.MyException;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Discription: 两个bean的顺序发生改变的情况没有去考虑
 * spring当中手动装配和自动装配的优先级
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

            Attribute attribute = rootElement.attribute("default-autowire");//是否是自动装配
            boolean flag = false;
            if (attribute == null) {
                flag = true;
            }

            //List<Element> allChild = rootElement.elements();
            for (Iterator<Element> itFirst = rootElement.elementIterator(); itFirst.hasNext(); ) {//遍历<beans>中的<bean>
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
                //Object object = clazz.newInstance();
                Object object = null;
                //维护依赖关系
                //看这个对象有没有依赖,判断是否有属性

                for (Iterator<Element> itSecond = rootElement.elementIterator(); itSecond.hasNext(); ) {//遍历<bean>中的<property>或<constructor-arg>

                    Element elementSecondChild = itSecond.next();
                    if (elementSecondChild.getName().equals("property")) {//setter注入的方式,没有特殊的构造方法

                        object = clazz.newInstance();

                        String refValue = elementSecondChild.attribute("ref").getValue();
                        Object target = map.get(refValue);
                        String nameValue = elementSecondChild.attribute("name").getValue();

                        Field field = clazz.getDeclaredField(nameValue);
                        //如果field == null 抛出一个自定义异常        看类中是否有依赖关系

                        field.setAccessible(true);
                        field.set(object, target);

                    } else if (elementSecondChild.getName().equals("constructor-arg")) {//构造函数注入的方式  一个args的情况
                        String refName = elementSecondChild.attribute("ref").getValue();//拿name去解析 属性的xml的name 是UserDao dao对应的
                        Object injectObject = map.get(refName);
                        Class injectObjectClazz = injectObject.getClass();
                        Constructor constructor = clazz.getConstructor(injectObjectClazz.getInterfaces()[0]);
                        object = constructor.newInstance(injectObject);
                    } else {
                        System.out.println("xml中的标签与实际不符合");
                    }
                }

                if (object == null) {//没有手动装配,才使用自动装配 手动>自动

                    if (flag) {//自动装配
                        if (attribute.getValue().equals("byType")) {//判断是否有依赖: xml中没有,判断类中是否有属性
                            Field[] fields = clazz.getDeclaredFields();
                            for (Field field : fields) {
                                //得到这个属性的类型,比如 String index 这里的field.getType()表示 String.class
                                Class injectObjectClazz = field.getType();
                                //byType需要遍历map中的所有对象,判断对象的类型是否与injectObjectClazz相同

                                int count = 0;
                                Object injectObject = null;
                                for (String key : map.keySet()) {
                                    Class temp = map.get(key).getClass().getInterfaces()[0];
                                    if (temp.getName().equals(injectObjectClazz.getName())) {
                                        injectObject = map.get(key);
                                        //记录找一个,因为可能找到多个
                                        count++;
                                    }
                                }

                                if (count > 1) {
                                    throw new MyException("需要一个对象,但是找到了两个");
                                } else {//注入
                                    object = clazz.newInstance();
                                    field.setAccessible(true);//允许去设置依赖关系
                                    field.set(object, injectObject);

                                }
                            }
                        }
                    }
                }


                if (object == null) {//没有子标签
                    object = clazz.newInstance();
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
