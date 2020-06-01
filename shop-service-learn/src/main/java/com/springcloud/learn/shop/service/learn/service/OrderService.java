package com.springcloud.learn.shop.service.learn.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "order-service-learn", fallback = OrderServiceFallback.class)

public interface OrderService {

    @GetMapping("/getOrder")
    String getOrder();

}
