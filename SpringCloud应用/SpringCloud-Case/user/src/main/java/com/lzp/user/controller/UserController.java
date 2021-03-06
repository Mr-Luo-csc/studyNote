package com.lzp.user.controller;

import com.lzp.user.resultmodel.R;
import com.lzp.user.service.PowerFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "fallBackMethod",
            threadPoolKey = "power",
            groupKey = "commonThreadPoolGroup",
            threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "5"),
                    @HystrixProperty(name = "maxQueueSize", value = "2")})
    //todo 1、maxQueueSize可等待的最大任务数 2、注解配置优先高于yml配置 3、命令名称commandKey参数
    public R getPower() {
        return R.success("操作成功[RestTemplate]", restTemplate.getForObject("http://localhost:6000/getPower.do?name='luozhipeng'", Object.class));
    }

    //======使用feign调用power模块 todo 添加方法降解
    @RequestMapping("/getPowerByFeign.do")
    @HystrixCommand(fallbackMethod = "fallBackMethod")
    public R getPowerByFeign(String name) {
        System.out.println(name);
        Object data = feign.getPower(name);
        return R.success("操作成功[Feign]", data);
    }

    //======失败时调用的方法 todo 参数可以打印、注意参数要一致
    public R fallBackMethod(String name) {
        System.out.println(name);
        return R.error("降级信息");
    }

    public R fallBackMethod() {
        return R.error("降级信息");
    }

}
