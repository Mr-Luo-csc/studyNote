package csc.lzp.factory.config;

import csc.lzp.factory.factorybean.dao.DaoFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/5/29
 **/
@Configuration
@ComponentScan("csc.lzp.factory")
public class AppConfig {

//    @Bean
//    public DaoFactoryBean bean() {
//        return new DaoFactoryBean();
//    }

}
