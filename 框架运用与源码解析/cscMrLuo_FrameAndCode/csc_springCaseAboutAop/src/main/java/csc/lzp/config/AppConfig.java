package csc.lzp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Discription: 配置类
 *
 * 关键字:【Full】加了@Configuration注解、【Lite】没有加Configuration注解
 *
 * @Author: luozhipeng
 * @Date: 2020/6/23
 **/
@Configuration
@ComponentScan(value = "csc.lzp")
public class AppConfig {



}
