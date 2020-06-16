package csc.lzp.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
public interface CardDao {

    @Select("select * from t_card where card_number like '%${number}%'")
    public List<Map<Integer, String>> list(@Param("number") String number);
}
