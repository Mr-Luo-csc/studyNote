package csc.lzp.test;

import csc.lzp.config.AppConfig;
import csc.lzp.dao.CardDao;
import csc.lzp.service.CardService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
public class Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CardService cardService = context.getBean(CardService.class);
        System.out.println("cardService是否存在: " + cardService);
        cardService.list();

        //CardDao cardDao = context.getBean(CardDao.class);
        CardDao cardDao = (CardDao) context.getBean("cardDao");
        cardDao.list("key_l");
        System.out.println("cardDao是否存在: " + cardDao);

    }
}
