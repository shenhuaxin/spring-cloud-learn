package com.springcloud.learn.shop.service.learn.config;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class OrderRuleConfig {



    @Bean
    public IRule getRule() {
        return new RoundRobinRule();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }
}
