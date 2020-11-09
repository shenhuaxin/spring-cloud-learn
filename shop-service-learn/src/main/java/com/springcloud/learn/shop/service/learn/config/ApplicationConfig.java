package com.springcloud.learn.shop.service.learn.config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClient(name = "order-service-learn", configuration = OrderRuleConfig.class)
public class ApplicationConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }



    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
