package csc.lzp.factory.factorybean.dao;

import csc.lzp.factory.factorybean.testbean.TempFactoryBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Discription: 如果你的类实现了FactoryBean spring容器中存在了两个bean
 * 1、当前对象 用的是 (& + 当前类的名字) 存储的
 * 2、getObject()返回的对象 用的是@Component("daoFactoryBean")存储的
 * @Author: luozhipeng
 * @Date: 2020/5/29
 **/
@Component("daoFactoryBean")
public class DaoFactoryBean implements FactoryBean {

    public void testBean() {
        System.out.println("testBean");
    }

    public Object getObject() throws Exception {
        return new TempFactoryBean();
    }

    public Class<?> getObjectType() {
        return TempFactoryBean.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
