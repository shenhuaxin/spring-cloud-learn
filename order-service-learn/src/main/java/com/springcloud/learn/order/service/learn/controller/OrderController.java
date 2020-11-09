package com.springcloud.learn.order.service.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    @Value("${server.port}")
    private String port;

    @GetMapping("getOrder")
    public String getOrder() {
//        if (port.equals("8083")) {
//            System.out.println("成功");
//        }else {
//            System.out.println("失败");
//            int i = 1/0;
//        }
        return "order: " +port;
    }


    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }


}
