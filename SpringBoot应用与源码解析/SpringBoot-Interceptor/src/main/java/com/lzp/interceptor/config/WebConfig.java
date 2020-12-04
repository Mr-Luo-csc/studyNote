package com.lzp.interceptor.config;

import com.lzp.interceptor.auth.LogInterceptor;
import com.lzp.interceptor.auth.OldLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: luozhipeng
 * @description: 配置拦截器, 走拦截器是有顺序的
 * @data: 2020-12-04
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /* 添加拦截器 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new OldLoginInterceptor()).addPathPatterns("/admin/oldLogin");

        registry.addInterceptor(new LogInterceptor());

    }

}
