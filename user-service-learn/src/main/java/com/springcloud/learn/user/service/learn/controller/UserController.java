package com.springcloud.learn.user.service.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${eureka.instance.instance-id}")
    private String port;

    @GetMapping("getUser")
    public String getUser() {
        System.out.println(port);
        return "user:"+port;
    }

}
