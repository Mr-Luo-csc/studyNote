package csc.lzp.test;

import csc.lzp.config.AppConfig;
import csc.lzp.handler.MyInvocationHandler;
import csc.lzp.dao.CardDao;
import csc.lzp.service.CardService;
import csc.lzp.service.CityService;
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
        CardService cardService = context.getBean(CardService.class);
        System.out.println("cardService是否存在: " + cardService);
        cardService.list();

        CardDao cardDao = context.getBean(CardDao.class);
        System.out.println("cardDao是否存在: " + cardDao);

//        CityService cityService = context.getBean(CityService.class);
//        System.out.println("cityService是否存在: " + cityService);
//        cityService.list();
    }
}
