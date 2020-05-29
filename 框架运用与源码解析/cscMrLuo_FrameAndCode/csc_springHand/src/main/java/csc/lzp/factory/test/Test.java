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
        TempFactoryBean tempFactoryBean = (TempFactoryBean) context.getBean("daoFactoryBean");
        tempFactoryBean.test();
    }
}
