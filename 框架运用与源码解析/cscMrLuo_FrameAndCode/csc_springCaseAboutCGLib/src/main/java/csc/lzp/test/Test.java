package csc.lzp.test;

import csc.lzp.config.AppConfig;
import csc.lzp.service.MyService1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/30
 **/
public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyService1 myService1 = (MyService1) context.getBean("myService1");
        MyService1 myService1Copy = (MyService1) context.getBean("myService1");
        System.out.println("两个相同代理的bean是否相等" + (myService1 == myService1Copy));

    }

}
