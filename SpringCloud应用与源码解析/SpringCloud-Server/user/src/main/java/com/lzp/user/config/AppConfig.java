package com.lzp.user.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/21
 **/
@Configuration
@ComponentScan("com.lzp.user")
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //======设置tomcat的端口号
    @Bean
    public TomcatServletWebServerFactory tomcat() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(8081);
        return tomcat;
    }

}
