package com.springcloud.learn.shop.service.learn.service;


import org.springframework.stereotype.Component;

@Component
public class OrderServiceFallback implements OrderService{
    @Override

    public String getOrder() {
        return "fallback";
    }
}
