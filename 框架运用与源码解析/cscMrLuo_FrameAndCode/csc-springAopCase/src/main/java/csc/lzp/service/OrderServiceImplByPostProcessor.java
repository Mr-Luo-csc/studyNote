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

    ApplicationContext applicationContext;

    public void query() {
        System.out.println("service层的查询订单方法");
        OrderDao orderDaoImplA = (OrderDao) applicationContext.getBean("orderDaoImplA");
        OrderDao orderDaoImplB = (OrderDao) applicationContext.getBean("orderDaoImplB");
        if (true) {

        } else if (false) {

        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
