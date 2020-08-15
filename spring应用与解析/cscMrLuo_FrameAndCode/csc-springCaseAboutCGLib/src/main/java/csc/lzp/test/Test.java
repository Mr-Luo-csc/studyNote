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

        /****************************************************************************************************************/
        /** 这里测试添加@Configuration注解的作用;有无添加@Configuration注解,看是否spring bean容器中是否有appConfig这个bean实例  */
        /** 基于接口的使用JDK动态代理                                                                                      */
        /** 基于继承的使用CGLib(ASM框架[操作字节码])代理                                                                    */
        /** 配置类如果不加@Configuration，就只返回了;不再走下面的动态代理                                                     */
        /****************************************************************************************************************/
        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println("配置类" + appConfig);

        MyService1 myService1 = (MyService1) context.getBean("myService1");
        MyService1 myService1Copy = (MyService1) context.getBean("myService1");
        System.out.println("两个相同代理的bean是否相等" + (myService1 == myService1Copy));

    }

}
