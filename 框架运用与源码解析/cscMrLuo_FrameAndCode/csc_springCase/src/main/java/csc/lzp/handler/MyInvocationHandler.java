package csc.lzp.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
public class MyInvocationHandler implements InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("aaa");
        return null;
    }
}
