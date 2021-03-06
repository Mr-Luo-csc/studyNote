package csc.lzp.test;

import csc.lzp.config.AppConfig;
import csc.lzp.config.DbConfig;
import csc.lzp.service.OrderServiceImpl;
import csc.lzp.service.OrderServiceImplByAutowire;
import csc.lzp.service.OrderServiceImplByPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription: 测试使用Aop
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
public class AppTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //测试注解版aop
        OrderServiceImpl orderService = context.getBean(OrderServiceImpl.class);
        orderService.query();

        //测试spring扩展点实现不用用户使用不同dao
        OrderServiceImplByPostProcessor orderServiceImplByPostProcessor = context.getBean(OrderServiceImplByPostProcessor.class);
        orderServiceImplByPostProcessor.query("A");
        orderServiceImplByPostProcessor.query("B");

        //测试使用@autowired注解的方式得到不用的dao,根据用户类型拿取dao
        OrderServiceImplByAutowire serviceImplByAutowire = context.getBean(OrderServiceImplByAutowire.class);
        serviceImplByAutowire.query("orderDaoImplA");

        //测试使用ImportAware
        DbConfig dbConfig = context.getBean(DbConfig.class);
        dbConfig.print();

        //测试获取启动过程中的bean 定义的名称
        for(String str : context.getBeanDefinitionNames()){
            System.out.println("=================   str = " + str);
        }

    }

}
