package com.springcloud.learn.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ORDER-SERVICE-LEARN")
public interface OrderService {


    @GetMapping("getOrder")
    public String getOrder();

}
