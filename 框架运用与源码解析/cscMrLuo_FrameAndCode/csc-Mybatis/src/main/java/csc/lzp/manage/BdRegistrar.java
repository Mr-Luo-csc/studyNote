package csc.lzp.manage;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/14
 **/
public class BdRegistrar implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        GenericBeanDefinition userClazzBeanDefinition = (GenericBeanDefinition) beanDefinitionRegistry.getBeanDefinition("userClazz");
        //设置bd的注入类型[不加@autowire自动注入]
        userClazzBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        beanDefinitionRegistry.registerBeanDefinition("userClazz", userClazzBeanDefinition);
    }

}
