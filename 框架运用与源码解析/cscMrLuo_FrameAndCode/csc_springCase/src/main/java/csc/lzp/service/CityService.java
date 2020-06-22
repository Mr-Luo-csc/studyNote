package csc.lzp.service;

import csc.lzp.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/22
 **/
@Service
public class CityService {

    @Autowired
    private CityDao cityDao;

    public CityService() {
        System.out.println("bean容器中拿到goodService");
    }

    public List<Map<String, Object>> list() {
        System.out.println("到PostgreSQL中查询数据");
        List<Map<String, Object>> result = cityDao.list();
        //需要实体类去映射
        System.out.println("第一条数据信息: " + result);
        return result;
    }

}
