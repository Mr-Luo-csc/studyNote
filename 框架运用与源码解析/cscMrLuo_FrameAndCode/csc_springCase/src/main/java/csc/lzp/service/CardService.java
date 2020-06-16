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

    @Autowired
    CardDao cardDao;

    public void list() {
        System.out.println(cardDao.list("10086"));
    }


    //TODO
    @PostConstruct
    public void init() {

    }

}
