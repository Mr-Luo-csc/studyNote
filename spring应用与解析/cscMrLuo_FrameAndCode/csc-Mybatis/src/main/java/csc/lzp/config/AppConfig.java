package csc.lzp.config;

import csc.lzp.manage.BdRegistrar;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/14
 **/
@Configuration
@ComponentScan(basePackages = "csc.lzp.model")
@Import(BdRegistrar.class)
//@MapperScan
public class AppConfig {

}
