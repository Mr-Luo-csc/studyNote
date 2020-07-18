package csc.lzp.handler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Discription: 这里处理bean 手动设置构造方法中参数的值
 * @Author: luozhipeng
 * @Date: 2020/7/18
 **/
@Component
public class MyHandler implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition orderServiceImpl = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("orderServiceImpl");
        ConstructorArgumentValues constructorArgumentValues = orderServiceImpl.getConstructorArgumentValues();
        //这里传字符串的话会转换成对象 #? TODO
        constructorArgumentValues.addGenericArgumentValue("csc.lzp.service.OrderServiceImplByAutowire");
    }

}
