package csc.lzp.staticproxy.inherit;

import csc.lzp.staticproxy.inherit.dao.MrLuoDao;
import csc.lzp.staticproxy.inherit.proxy.MrLuoProxy;

/**
 * @Discription:
 * @Author: luozhipeng
 **/
public class AppTest {

    public static void main(String[] args) {
        MrLuoDao mrLuoDao = new MrLuoProxy();
        mrLuoDao.query();
        System.out.println("----------分割线----------");
        MrLuoProxy mrLuoProxy = new MrLuoProxy();
        mrLuoDao.query();
    }

}
