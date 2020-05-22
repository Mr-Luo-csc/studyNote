package csc.lzp.actionproxy;

import csc.lzp.staticproxy.inherit.dao.Impl.MrLuoDaoImpl;
import csc.lzp.staticproxy.inherit.dao.MrLuoDao;

import java.lang.reflect.Proxy;

/**
 * @Discription:
 * @Author: luozhipeng
 **/
public class Test {

    public static void main(String[] args) {
        MrLuoDao mrLuoDao = new MrLuoDaoImpl();
        /**loader:类加载器**/
        /**interfaces:你需要增强的接口**/
        /**InvocationHandler中的invoke方法:用于实现代理逻辑的**/
        Object o = Proxy.newProxyInstance(null, null, null);
    }

}
