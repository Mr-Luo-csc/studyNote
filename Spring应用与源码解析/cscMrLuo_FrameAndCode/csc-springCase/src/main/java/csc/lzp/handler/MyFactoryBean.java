package csc.lzp.handler;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Discription: FactoryBean会返回两个对象 1、一个是自己;2、另一个是getObject()返回的对象
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
//@Component #?
public class MyFactoryBean implements FactoryBean, InvocationHandler {

    Class clazz;

    /**
     * 描述: 添加了一个构造方法,spring要解析
     */
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
        //得到代理对象的接口,得到接口方法
        Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName(), String.class);
        Select select = method1.getDeclaredAnnotation(Select.class);
        System.out.println("sql: " + select.value()[0]);
        return null;
    }
}
