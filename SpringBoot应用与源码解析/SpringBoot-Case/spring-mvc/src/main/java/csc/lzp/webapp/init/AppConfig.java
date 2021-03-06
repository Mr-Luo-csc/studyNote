package csc.lzp.webapp.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/18
 **/
@Configuration
@ComponentScan("csc.lzp.webapp")
//@EnableWebMvc todo 这里了解一下 以前的web项目需要添加这个注解
public class AppConfig {

    @Bean
    //@Autowired todo 该注解加在方法上的作用是什么?
    public MyParser myParser() {
        return new MyParser();
    }

}
