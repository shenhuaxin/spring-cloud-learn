package com.springcloud.learn.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderRuleConfig {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }



//    @Bean
//    public IPing ribbonPing() {
//        return new PingUrl();
//    }
}
