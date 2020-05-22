package csc.lzp.staticproxy.aggregate.proxy;

import csc.lzp.staticproxy.aggregate.dao.KeyLDao;

/**
 * @Discription:
 * @Author: luozhipeng
 **/
public class KeyLDaoProxy implements KeyLDao {

    KeyLDao keyLDao;

    public KeyLDaoProxy(KeyLDao keyLDao) {
        this.keyLDao = keyLDao;
    }

    public void query() {
        System.out.println("打印日志的逻辑");
        keyLDao.query();
    }
}
