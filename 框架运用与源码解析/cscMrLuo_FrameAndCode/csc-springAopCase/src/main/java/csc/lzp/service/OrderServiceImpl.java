package csc.lzp.service;

import csc.lzp.dao.OrderDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Service
public class OrderServiceImpl implements InitializingBean {

   /* public OrderServiceImpl() {
        System.out.println("执行了OrderServiceImpl的无参构造方法...");
    }*/

    Class orderDao;

    //--------------测试有参构造方法设置值------------------//
    public OrderServiceImpl(Class orderDao) {
        this.orderDao = orderDao;
        //spring会忽略Class类型的属性这里不会自动装配,mybatis中也是通过设置构造方法设置对应参数实现的,字符串变成对象的过程[这里不需要知道是怎么实现的]
        System.out.println("执行了OrderServiceImpl的有参构造方法...");
    }

    public void query() {
        System.out.println("service层的查询订单方法");
        System.out.println("orderService中orderDao的属性是否赋值了: " + this.orderDao);
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("经过afterPropertiesSet方法处理... 通过测试可知:初始化bean的时候会执行该方法");
        System.out.println("InitializingBean在sprint中的执行顺序[个人理解]:bean实例化后,生成代理对象之前[BeanPostProcessor]");
    }
}
