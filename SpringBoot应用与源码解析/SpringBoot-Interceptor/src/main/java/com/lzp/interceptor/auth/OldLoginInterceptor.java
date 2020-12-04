package com.lzp.interceptor.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-12-04
 **/
@Slf4j
public class OldLoginInterceptor extends HandlerInterceptorAdapter {

    /* 当前端请求[/admin/oldLogin]的时候拦截,直接重定向到[/admin/login]接口 */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {
        log.info("Request URL: " + request.getRequestURL());
        response.sendRedirect(request.getContextPath() + "/admin/login");
        return false;//todo 这里是否会return
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        log.info("这里不会走....");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        log.info("这里不会走....");
    }
}
