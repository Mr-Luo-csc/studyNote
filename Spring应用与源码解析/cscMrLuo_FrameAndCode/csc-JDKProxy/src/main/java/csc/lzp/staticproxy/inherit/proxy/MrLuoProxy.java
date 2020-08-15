package csc.lzp.staticproxy.inherit.proxy;

import csc.lzp.staticproxy.inherit.dao.Impl.MrLuoDaoImpl;

/**
 * @Discription: 继承的方式实现代理对象
 * @Author: luozhipeng
 **/
public class MrLuoProxy extends MrLuoDaoImpl {
    @Override
    public void query() {
        super.query();
        System.out.println("实现打印日志的逻辑");
    }
}
