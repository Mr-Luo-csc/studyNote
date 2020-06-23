package csc.lzp.test;

import csc.lzp.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/23
 **/
public class Test {

    public static void main(String[] args) {
        //容器中有spring内部的bd有6个
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.register();
        context.refresh();
    }

}
