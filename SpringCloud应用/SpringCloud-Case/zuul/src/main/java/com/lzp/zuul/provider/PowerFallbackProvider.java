package com.lzp.zuul.provider;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 容错回退
 * @Author: luozhipeng
 * @Date: 2020/9/3
 **/
//todo 微服务级别的退回;不能指定到某个接口[controller]
@Component
public class PowerFallbackProvider implements FallbackProvider {

    //======todo 这里截取的是微服务的名称?
    @Override
    public String getRoute() {
        return "server-power";
    }

    //======回退的逻辑回调的方法
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        if (cause instanceof HystrixTimeoutException) {
            //网关超时
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            //内部服务器错误
            return response(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ClientHttpResponse response(final HttpStatus status) {

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            //============================todo 以下三个方法比较重要===============================//
            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("系统繁忙,请稍后再试...".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
