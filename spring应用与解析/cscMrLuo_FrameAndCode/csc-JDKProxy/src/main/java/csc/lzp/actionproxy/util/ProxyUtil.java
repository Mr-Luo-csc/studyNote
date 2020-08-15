package csc.lzp.actionproxy.util;

/**
 * @Discription: 动态代理工具类
 * 动态代理不是生成一个目标实例对象
 * 而是将字符串编译一个代理对象的过程,通过反射来实现的
 * @Author: luozhipeng
 **/
public class ProxyUtil {

    /**编写一个创建实例的公共静态方法**/
    public static Object newInstance(Class targetObject) {

        targetObject.getSimpleName();

        return null;
    }
}
