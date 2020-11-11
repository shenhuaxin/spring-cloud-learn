package com.springcloud.learn.user.service.learn.controller;

import com.springcloud.learn.user.service.learn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${eureka.instance.instance-id}")
    private String port;

    @Autowired
    private OrderService orderService;

    @GetMapping("getUser")
    public String getUser() {
       return orderService.getOrder();
    }
}
