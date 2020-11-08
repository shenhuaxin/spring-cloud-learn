package com.springcloud.learn.shop.service.learn;

import com.springcloud.learn.shop.service.learn.config.OrderRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopServiceLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServiceLearnApplication.class, args);
    }

}
