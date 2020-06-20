package csc.lzp.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
@Repository
public interface CardDao {

    @Select("select * from t_card where card_number like '%${number}%'")
    List<Map<Integer, String>> list(@Param("number") String number);
}
