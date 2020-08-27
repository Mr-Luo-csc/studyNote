package ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/27
 **/
@Configuration
public class PowerRuleConfig {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
