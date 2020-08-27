package com.lzp.user.controller;

import com.lzp.user.resultmodel.R;
import com.lzp.user.service.PowerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/25
 **/
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PowerFeign feign;

    //======user模块
    @RequestMapping("/getUser.do")
    public R getUser() {
        Map<String, Object> map = new HashMap<>();
        map.put("dancer", "locker");
        return R.success("返回成功", map);
    }

    //======调用power模块
    @RequestMapping("/getPower.do")
    public R getPower() {
        return R.success("操作成功[RestTemplate]", restTemplate.getForObject("http://localhost:6000/getPower.do", Object.class));
    }

    //======使用feign调用power模块
    @RequestMapping("/getPowerByFeign.do")
    public R getPowerByFeign() {
        Object data = feign.getPower();
        return R.success("操作成功[Feign]", data);
    }

}
