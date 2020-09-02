package com.lzp.power.controller;

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
public class PowerController {

    @RequestMapping("/getPower.do")
    public Object getPower(String name) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("city", "长沙HOOK");
        if (name == null) {
            //如果没有传参数,我们模拟抛出一个异常
            throw new Exception();
        }
        //todo 模拟并发,多个线程访问资源
        //Thread.sleep(1000 * 10);
        return map;
    }

}
