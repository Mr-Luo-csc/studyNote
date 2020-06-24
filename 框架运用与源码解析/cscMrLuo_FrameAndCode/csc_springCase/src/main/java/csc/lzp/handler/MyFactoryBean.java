package csc.lzp.handler;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
@Component
public class MyFactoryBean implements FactoryBean, InvocationHandler {

    Class clazz;

    public MyFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    public Object getObject() throws Exception {
        Class[] clazzs = new Class[]{clazz};
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), clazzs, this);
        return proxy;
    }

    public Class<?> getObjectType() {
        return clazz;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        return null;
    }
}
