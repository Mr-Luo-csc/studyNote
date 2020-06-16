package csc.lzp.handler;

import csc.lzp.dao.CardDao;
import csc.lzp.test.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Proxy;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        /**
         * 1、得到BD
         * 2、扫描
         *
         */

        CardDao dao = (CardDao) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{CardDao.class}, new MyInvocationHandler());
        //CardDao.class——代理对象:dao
        dao.list("xxx");
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(dao.getClass());//这里写死
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("cardDao", beanDefinition);
    }
}
