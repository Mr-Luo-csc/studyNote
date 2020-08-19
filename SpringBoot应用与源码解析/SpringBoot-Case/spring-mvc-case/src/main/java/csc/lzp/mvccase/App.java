package csc.lzp.mvccase;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/19
 **/
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //todo springboot启动有很多种方式,当前这种方式是最普遍常见的
        SpringApplication.run(App.class, args);
    }

    /**************************/
    /**         @bean         */
    /** todo 注解标注在方法上   */
    /**************************/
    @Bean
    public HttpMessageConverters httpMessageConverters() {
        //todo 如若环境中没有 HttpMessageConverters 会自动注入一个 DefaultMessageConverters

        //这里我们可以用配置类的方式 implements WebMvcConfigurer 调用解析器手动添加的方式
        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
    }


}
