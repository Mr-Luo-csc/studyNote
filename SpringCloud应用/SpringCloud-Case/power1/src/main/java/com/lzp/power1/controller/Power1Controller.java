package com.lzp.power1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/25
 **/
@RestController
public class Power1Controller {

    @RequestMapping("/getPower.do")
    public Object getPoser() {
        Map<String, Object> map = new HashMap<>();
        map.put("city", "长沙HOOK");
        return map;
    }

}
