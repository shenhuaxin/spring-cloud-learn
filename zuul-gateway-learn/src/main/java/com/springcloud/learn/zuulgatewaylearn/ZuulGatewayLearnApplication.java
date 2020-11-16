package com.springcloud.learn.zuulgatewaylearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayLearnApplication.class, args);
	}

}
