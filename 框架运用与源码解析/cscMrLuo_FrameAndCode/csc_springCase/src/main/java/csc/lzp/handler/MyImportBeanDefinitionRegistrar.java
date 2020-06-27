package csc.lzp.handler;

import csc.lzp.dao.CardDao;
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
         */

        //CardDao dao = (CardDao) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{CardDao.class}, new MyInvocationHandler());
        //===//CardDao.class——代理对象:dao
        //dao.list("xxx");

        //构建bd [方式一:dao.getClass()]
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(CardDao.class);//这里写死(实际是:扫描所有接口)
        //获取cardDao-bd
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();//bd (beanClass=CardDao.class|实际:[$Proxy01.class])
        //处理bd,添加构造方法(自动装配三种方式:1、byName;2、byType;3、byC(构造方法))
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("csc.lzp.dao.CardDao");//注意与下一步的顺序
        //使用FactoryBean处理一下beanDefinition
        beanDefinition.setBeanClass(MyFactoryBean.class);//(返回了一个特殊对象)
        //把这个bd放入spring容器
        beanDefinitionRegistry.registerBeanDefinition("cardDao", beanDefinition);
    }
}
