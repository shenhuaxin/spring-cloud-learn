package com.springcloud.learn.shop.service.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShopController {


    private String USER_SERVICE_URL = "http://user-service-learn";

    private String ORDER_SERVICE_URL = "http://order-service-learn";


    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("getUser")
    public String getUser() {
        return restTemplate.getForObject(USER_SERVICE_URL + "/getUser", String.class);
    }

    @GetMapping("getOrder")
    public String getOrder() {
        return restTemplate.getForObject(ORDER_SERVICE_URL + "/getOrder", String.class);
    }

}
