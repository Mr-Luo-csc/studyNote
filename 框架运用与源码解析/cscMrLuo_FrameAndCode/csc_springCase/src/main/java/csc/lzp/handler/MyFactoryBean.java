package csc.lzp.handler;

import csc.lzp.dao.CardDao;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/

public class MyFactoryBean implements FactoryBean {

    public Object getObject() throws Exception {
        Class[] clazz = {CardDao.class};
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), clazz, new MyInvocationHandler());
        return proxy;
    }

    public Class<?> getObjectType() {
        return CardDao.class;
    }
}
