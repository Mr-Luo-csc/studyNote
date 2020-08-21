package com.lzp.user.controller;

import com.lzp.user.model.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/21
 **/
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getUser.do")
    public R getUser() {
        Map<String, Object> data = new HashMap<>();
        data.put("key", "user");
        return R.success("请求成功", data);
    }

    @RequestMapping("/getPower.do")
    public R getPower() {
        return R.success("成功调用power微服务", restTemplate.getForObject("http://localhost:80/getPower.do", Object.class));
    }


}
