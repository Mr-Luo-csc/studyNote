package csc.lzp.webapp.init;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/19
 **/
public class MyParser {

    public MyParser() {
        List list = new WebMvcConfigurationSupport() {
            public List<HttpMessageConverter<?>> defaultMessageConverters() {
                super.getMessageConverters().add(new FastJsonHttpMessageConverter());
                return super.getMessageConverters();
            }
        }.defaultMessageConverters();
        System.out.println("已经手动添加了解析器...");
    }

}
