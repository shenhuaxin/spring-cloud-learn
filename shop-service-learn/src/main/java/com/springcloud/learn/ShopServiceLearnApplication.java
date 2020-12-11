package com.springcloud.learn;

import com.springcloud.learn.config.OrderRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
//@EnableDiscoveryClient
@RibbonClients(defaultConfiguration = OrderRuleConfig.class)
public class ShopServiceLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServiceLearnApplication.class, args);
    }

}
