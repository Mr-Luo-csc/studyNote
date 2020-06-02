package csc.lzp.dealtool;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Discription: 定义一个自己的后置处理器 这里设置把bean的scope变成圆形的
 * 这个类是在bean实例化之前起作用的
 * @Author: luozhipeng
 * @Date: 2020/6/2
 **/

@Component
public class MyPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //实现你自己所需定义的bean类型
        BeanDefinition bd = beanFactory.getBeanDefinition("myService");
        bd.setScope("prototype");
    }

}
