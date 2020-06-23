package csc.lzp.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/24
 **/
public class MyInvocationHandler implements InvocationHandler {

    Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //传目标对象
        System.out.println("我是代理方法");
        return method.invoke(target, args);
    }

}
