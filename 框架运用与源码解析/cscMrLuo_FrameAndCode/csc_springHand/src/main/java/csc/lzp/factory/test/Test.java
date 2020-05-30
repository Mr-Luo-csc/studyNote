package csc.lzp.factory.test;

import csc.lzp.factory.config.AppConfig;
import csc.lzp.factory.factorybean.testbean.TempFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/5/29
 **/
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //context.refresh();
        //translateBeanName()方法的含义 一个类的复杂关系的时候可以用到factoryBean
        //mybatis  sqlSessionFactoryBean的使用 @mapperScan是mybatis框架中的注解
        TempFactoryBean tempFactoryBean = (TempFactoryBean) context.getBean("daoFactoryBean");
        tempFactoryBean.test();
    }
}
