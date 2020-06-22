package csc.lzp.test;

import csc.lzp.config.AppConfig;
import csc.lzp.handler.MyInvocationHandler;
import csc.lzp.dao.CardDao;
import csc.lzp.service.CardService;
import csc.lzp.service.GoodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
public class Test {
    public static void main(String[] args) {

        //1、转对象
        //2、实现 CardDao
        //3、放入spring bean中
        //CardDao dao = (CardDao) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{CardDao.class}, new MyInvocationHandler());
        //dao.list("111");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        CardService cardService = context.getBean(CardService.class);
//        System.out.println("cardService是否存在: " + cardService);
        CardDao cardDao = context.getBean(CardDao.class);
        System.out.println("cardDao是否存在: " + cardDao);

        GoodService goodService = context.getBean(GoodService.class);
        System.out.println("goodService是否存在: " + goodService);

//        cardService.list();
    }
}
