package csc.lzp.test;

import csc.lzp.config.AppConfig;
import csc.lzp.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription:
 *
 * ASM 是一个通用的 Java 字节码操作和分析框架。它可以用于修改现有类或直接以二进制形式动态生成类。
 * ASM 虽然提供与其他 Java 字节码框架如 Javassist，CGLIB类似的功能，但是其设计与实现小而快，且性能足够高。
 * Spring 直接将 ASM 框架核心源码内嵌于 Spring-core中
 *
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
