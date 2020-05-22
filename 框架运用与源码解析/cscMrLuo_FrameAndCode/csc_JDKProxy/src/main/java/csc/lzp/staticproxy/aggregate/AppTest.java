package csc.lzp.staticproxy.aggregate;

import csc.lzp.staticproxy.aggregate.dao.Impl.KeyLDaoImpl;
import csc.lzp.staticproxy.aggregate.dao.KeyLDao;
import csc.lzp.staticproxy.aggregate.proxy.KeyLDaoProxy;

/**
 * @Discription: 测试使用聚合方式实现的静态代理
 * @Author: luozhipeng
 **/
public class AppTest {

    public static void main(String[] args) {
        KeyLDao keyLDao = new KeyLDaoProxy(new KeyLDaoImpl());
        keyLDao.query();
    }
}
