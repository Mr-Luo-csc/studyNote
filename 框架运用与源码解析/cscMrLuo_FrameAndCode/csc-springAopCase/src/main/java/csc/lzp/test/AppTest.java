package csc.lzp.test;

import csc.lzp.config.AppConfig;
import csc.lzp.service.OrderServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription: 测试使用Aop
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
public class AppTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderServiceImpl orderService = context.getBean(OrderServiceImpl.class);
        orderService.query();
    }

}
