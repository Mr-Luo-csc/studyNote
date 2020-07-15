package csc.lzp.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Service
class OrderServiceImplByPostProcessor implements BeanFactoryAware {

    BeanFactory beanFactory;

    public void query() {
        System.out.println("service层的查询订单方法");

        if (true) {

        } else if (false) {

        }
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
