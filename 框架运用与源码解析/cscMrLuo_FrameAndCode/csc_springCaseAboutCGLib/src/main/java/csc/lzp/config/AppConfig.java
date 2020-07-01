package csc.lzp.config;

import csc.lzp.service.MyService1;
import csc.lzp.service.MyService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Discription: FULL and LITE
 * 引用第三方的——使用@bean注解
 * @Author: luozhipeng
 * @Date: 2020/6/30
 **/
@Configuration
@ComponentScan(basePackages = "csc.lzp")
public class AppConfig {

   /* @Bean
    public Dao index1() {
        return new IndexDao1();
    }

    @Bean
    public Dao index2() {
        return new IndexDao2();
    }*/

    @Bean
    public static MyService1 myService1() {
        return new MyService1();
    }

    @Bean
    public MyService2 myService2() {
        return new MyService2();
    }

}
