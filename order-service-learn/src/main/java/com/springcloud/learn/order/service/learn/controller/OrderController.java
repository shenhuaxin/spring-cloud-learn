package com.springcloud.learn.order.service.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    @Value("${eureka.instance.instance-id}")
    private String port;

    @GetMapping("getOrder")
    public String getOrder() {
        throw  new RuntimeException("获取数据异常");
//        return "Order" + port;
    }


}
