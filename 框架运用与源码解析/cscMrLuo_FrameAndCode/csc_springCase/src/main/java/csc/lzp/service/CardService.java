package csc.lzp.service;

import csc.lzp.dao.CardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
@Component
public class CardService {

    /**
     * 描述1: 这里的cardDao肯定是一个对象,而不是接口,spring处理了接口到对象的这个过程
     * 描述1: @mapperScan扫描;把我们的接口转换成了对象;对象在spring容器当中;其中有@import注解,Spring会去解析,bean注册器(放入容器中)
     */
    @Autowired
    private CardDao cardDao;

    public void list() {
        System.out.println(cardDao.list("key_l"));
    }


    //TODO
    @PostConstruct
    public void init() {

    }

}
