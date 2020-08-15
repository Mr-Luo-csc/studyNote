package csc.lzp.test;

import csc.lzp.config.MyConfig;
import csc.lzp.dealtool.MyPostProcessor;
import csc.lzp.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/5/28
 **/
public class Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);

        //添加自定义的beanFactoryPostProcessor
        context.addBeanFactoryPostProcessor(new MyPostProcessor());

        context.refresh();

        Object myService = context.getBean(MyService.class);
        Object myService2 = context.getBean(MyService.class);

        System.out.println("当前自定义后置处理的方式是: 在bean实例化之前");
        System.out.println(myService.hashCode() + "======" + myService2.hashCode());

        System.out.println("得到容器中的bean" + myService);
    }
}
