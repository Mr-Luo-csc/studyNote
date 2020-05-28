package csc.lzp.test;

import csc.lzp.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/5/28
 **/
public class Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Object myService = context.getBean("myService");
        System.out.println("得到容器中的bean" + myService);
    }
}
