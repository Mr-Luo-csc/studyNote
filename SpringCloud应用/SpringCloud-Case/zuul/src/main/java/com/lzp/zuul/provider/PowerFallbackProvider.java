package com.lzp.zuul.provider;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @Description: 容错回退
 * @Author: luozhipeng
 * @Date: 2020/9/3
 **/
//todo 微服务级别的退回;不能指定到某个接口[controller]
@Component
public class PowerFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        return "power";
    }

    //======回退的逻辑回调的方法
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {


        return null;
    }
}
