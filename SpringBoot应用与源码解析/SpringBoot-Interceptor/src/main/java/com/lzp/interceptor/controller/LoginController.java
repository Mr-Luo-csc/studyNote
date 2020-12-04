package com.lzp.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: luozhipeng
 * @description: 登录验证授权
 * @data: 2020-12-04
 **/
@RestController
public class LoginController {

    @GetMapping("/admin/login")
    public String login() {
        return "Hello world!!!";
    }

    @GetMapping("/admin/oldLogin")
    public String oldLogin() {
        return "oldLogin";
    }

}
