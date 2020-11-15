package com.springcloud.learn.controller;

import com.springcloud.learn.entity.Order;
import com.springcloud.learn.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {


    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("createOrder")
    public String createOrder(@RequestParam("userId") Long userId, @RequestParam("goodsId") Long goodsId) {
        Order order = new Order();
        order.setUserId(userId);
        order.setGoodId(goodsId);
        order.setVersion(1L);
        orderRepository.save(order);
        return "创建订单成功过";
    }

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }


}
