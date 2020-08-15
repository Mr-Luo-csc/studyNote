package csc.lzp.service;

import csc.lzp.dao.CardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/8
 **/
@Service
public class CardService {

    @Autowired
    private CardDao cardDao;

    public List<Map<String, Object>> query() {
        List<Map<String, Object>> result = cardDao.query();
        return result;
    }
}
