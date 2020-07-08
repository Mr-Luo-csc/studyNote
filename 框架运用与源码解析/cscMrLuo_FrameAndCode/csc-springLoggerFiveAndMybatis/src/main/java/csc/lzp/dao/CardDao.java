package csc.lzp.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/8
 **/
@Repository
public interface CardDao {

    //--------------查询--------------//
    List<Map<String, Object>> query();

    //--------------修改--------------//
    void update();
}
