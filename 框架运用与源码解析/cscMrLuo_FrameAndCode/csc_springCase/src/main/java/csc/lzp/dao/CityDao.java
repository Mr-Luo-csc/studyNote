package csc.lzp.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/22
 **/
@Repository
public interface CityDao {

    //List<Map<String, Object>>可以不用映射实体类,直接拿到数据库中的数据
    @Select(value = "select * from t_city")
    List<Map<String, Object>> list();

}
