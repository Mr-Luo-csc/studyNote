package csc.lzp.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/18
 **/
@Controller
//todo spring中有三种类型的controller,我们通常都用加了@controller注解类型的controller
public class IndexController {

    @RequestMapping("/method1")
    public void method1() {
        System.out.println("method1接口被请求了...");
    }

    @RequestMapping("/method2")
    public void method2() {
        System.out.println("method2接口被请求了...");
    }

}
