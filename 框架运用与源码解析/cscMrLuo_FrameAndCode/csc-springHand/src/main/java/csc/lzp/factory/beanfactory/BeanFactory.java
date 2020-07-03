package csc.lzp.factory.beanfactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Discription: Spring中的bean工厂, 用来产生bean的, 里面一个重要的方法是 getBean()
 * @Author: luozhipeng
 * @Date: 2020/5/28
 **/
public class BeanFactory {

    public static void main(String[] args) {
        org.springframework.beans.factory.BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        factory.getBean("");
    }

}
