package com.springcloud.learn.shop.service.learn;

import com.springcloud.learn.shop.service.rule.OrderRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(value = "order-service-learn", configuration = OrderRuleConfig.class)
public class ShopServiceLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServiceLearnApplication.class, args);
    }

}
