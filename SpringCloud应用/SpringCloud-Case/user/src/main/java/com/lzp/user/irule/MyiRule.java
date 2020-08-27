package com.lzp.user.irule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

/**
 * @Description: 自己模拟的负载均衡策略
 * @Author: luozhipeng
 * @Date: 2020/8/27
 **/

public class MyiRule extends AbstractLoadBalancerRule {

    /*******************************************************************************/
    /** 伪随机，当一个下标（微服务） 连续被调用两次， 第三次如果还是它， 那么咱们就再随机一次。*/
    /*******************************************************************************/

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return null;
    }
}
