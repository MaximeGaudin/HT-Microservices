package com.mgaudin.sandbox.ht.front;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NetflixConfiguration {
    @Bean
    public IRule getLoadBalancingRule() {
        return new WeightedResponseTimeRule();
    }
}
