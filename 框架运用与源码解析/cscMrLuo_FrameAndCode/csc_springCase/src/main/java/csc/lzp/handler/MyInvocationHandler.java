package csc.lzp.handler;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
public class MyInvocationHandler implements InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy_我是经过代理的对象哦");
        Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName(), String.class);
        Select select = method1.getDeclaredAnnotation(Select.class);
        System.out.println("sql: " + select.value()[0]);
        return null;
    }
}
