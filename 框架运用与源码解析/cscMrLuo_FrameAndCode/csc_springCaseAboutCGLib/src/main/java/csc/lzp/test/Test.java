package csc.lzp.test;

import csc.lzp.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/30
 **/
public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        AppConfig appConfig = context.getBean(AppConfig.class);

    }

}
