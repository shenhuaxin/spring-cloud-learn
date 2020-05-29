package com.springcloud.learn.discovery.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryLearnApplication.class, args);
    }

}
