package com.springcloud.learn.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    private String ORDER_SERVICE_URL = "http://order-service-learn";


    @HystrixCommand(fallbackMethod = "getOrderDefault")
    public String getOrder() {
        return restTemplate.getForObject(ORDER_SERVICE_URL + "/getOrder", String.class);
    }


    public String getOrderDefault() {
        return "order-default";
    }

}
