package com.springcloud.learn.shop.service.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShopServiceLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServiceLearnApplication.class, args);
    }

}
