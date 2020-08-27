package com.lzp.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/27
 **/
//@FeignClient("SERVER-POWER")
//todo feign一定要加name属性吗
@FeignClient(name = "SERVER-POWER", url = "http://localhost:6000")
public interface PowerFeign {

    @RequestMapping("/getPower.do")
    Object getPower();
}
