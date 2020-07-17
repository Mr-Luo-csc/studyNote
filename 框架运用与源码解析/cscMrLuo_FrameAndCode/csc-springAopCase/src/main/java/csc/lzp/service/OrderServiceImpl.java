package csc.lzp.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Service
public class OrderServiceImpl implements InitializingBean {

    public OrderServiceImpl() {
        System.out.println("执行了OrderServiceImpl的无参构造方法...");
    }

    public void query() {
        System.out.println("service层的查询订单方法");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("经过afterPropertiesSet方法处理... 通过测试可知:初始化bean的时候会执行该方法");
        System.out.println("InitializingBean在sprint中的执行顺序[个人理解]:bean实例化后,生成代理对象之前[BeanPostProcessor]");
    }
}
