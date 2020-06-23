package csc.lzp.test;

import csc.lzp.config.AppConfig;
import csc.lzp.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/23
 **/
public class Test {

    public static void main(String[] args) {
        //容器中有spring内部的bd有6个
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        //拿到的是代理对象,这里拿不到indexDao1
        Dao dao = (Dao) context.getBean("indexDao1");
        dao.query();
    }

}
