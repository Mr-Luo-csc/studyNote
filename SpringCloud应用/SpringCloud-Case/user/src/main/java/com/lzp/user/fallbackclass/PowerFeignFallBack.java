package com.lzp.user.fallbackclass;

import com.lzp.user.resultmodel.R;
import com.lzp.user.service.PowerFeign;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/9/1
 **/
//@Component
//todo @Component这个注解一定需要添加[或者]在@EnableFeignClients注解中指定路径;fallBackMethod的优先级大于fallBackClass
public class PowerFeignFallBack implements PowerFeign {

    @Override
    public Object getPower(String name) {
        return R.error("power服务暂时不可用...");
    }

}
