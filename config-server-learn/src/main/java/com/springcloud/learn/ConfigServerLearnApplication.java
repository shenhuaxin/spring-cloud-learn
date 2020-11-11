package com.springcloud.learn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerLearnApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConfigServerLearnApplication.class, args);
    }

}
