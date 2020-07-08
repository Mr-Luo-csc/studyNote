package csc.lzp.test;

import csc.lzp.config.AppConfig;
import csc.lzp.service.CardService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription: 测试使用Mybatis的一级缓存(只能在只有mybatis框架的项目中实现)、二级缓存
 * @Author: luozhipeng
 * @Date: 2020/7/7
 **/
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //拿到业务层调数据层查询数据库
        CardService cardService = context.getBean(CardService.class);
        cardService.query();

    }

}
