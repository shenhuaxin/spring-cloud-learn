package com.springcloud.learn.shop.service.learn;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.springcloud.learn.shop.service.learn.config.OrderRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
//@RibbonClients(value = {
//        @RibbonClient(name = "order-service-learn", configuration = OrderRuleConfig.class)
//})
@RibbonClients(defaultConfiguration = OrderRuleConfig.class)
public class ShopServiceLearnApplication {

//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }



    public static void main(String[] args) {
        SpringApplication.run(ShopServiceLearnApplication.class, args);
    }

}
