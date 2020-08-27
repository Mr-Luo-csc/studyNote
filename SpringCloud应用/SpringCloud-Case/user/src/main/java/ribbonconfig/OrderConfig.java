package ribbonconfig;

import com.lzp.user.irule.MyiRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/27
 **/
@Configuration
public class OrderConfig {

    @Bean
    public IRule iRule() {
        return new MyiRule();
    }
}
