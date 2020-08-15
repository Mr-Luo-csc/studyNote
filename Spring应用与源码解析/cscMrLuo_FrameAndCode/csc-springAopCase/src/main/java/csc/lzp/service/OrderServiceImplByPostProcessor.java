package csc.lzp.service;

import csc.lzp.dao.OrderDao;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Service
public class OrderServiceImplByPostProcessor implements ApplicationContextAware {

    //----------------------给当前service层添加applicationContext属性-------------------------//
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //----------------不用用户调用不同的Dao-------------------//
    public void query(String userName) {
        if (userName.equals("A")) {
            OrderDao orderDaoImplA = (OrderDao) applicationContext.getBean("orderDaoImplA");
            orderDaoImplA.query();
        } else if (userName.equals("B")) {
            OrderDao orderDaoImplB = (OrderDao) applicationContext.getBean("orderDaoImplB");
            orderDaoImplB.query();
        }
    }

}
