package com.springcloud.learn.order.service.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class OrderServiceLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceLearnApplication.class, args);
    }

}
