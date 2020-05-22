package csc.lzp.staticproxy.inherit;

import csc.lzp.staticproxy.inherit.dao.Impl.MrLuoDaoImpl;
import csc.lzp.staticproxy.inherit.dao.MrLuoDao;

/**
 * @Discription:
 * @Author: luozhipeng
 **/
public class Test {

    public static void main(String[] args) {
        MrLuoDao mrLuoDao = new MrLuoDaoImpl();
    }

}
