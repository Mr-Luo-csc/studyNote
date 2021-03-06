package com.lzp.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: zuul里面的核心[过滤器]
 * @Author: luozhipeng
 * @Date: 2020/9/2
 **/
@Component
//todo Pre类型的过滤器,日志打印
public class LogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //todo 什么时候+1,想拿到更多资源的时候;每个过滤器,zuul组件都有一个默认的
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String remoteAddr = request.getRemoteAddr();
        //todo ConcurrentMap
        String s = currentContext.get(FilterConstants.REQUEST_URI_KEY).toString();
        System.out.println("访问者IP: " + remoteAddr + "访问地址: " + s);
        return null;
    }
}
