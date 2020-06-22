package com.springcloud.learn.jpalearn.rest;


import com.springcloud.learn.jpalearn.mapper.OrderMapper;
import com.springcloud.learn.jpalearn.mapper.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping(value = "test")
    public void test() {
        UserEntity userEntity = new UserEntity();
        userEntity.setDate("2020-08-16 11:12:12");
        orderMapper.insert(userEntity);


        System.out.println(orderMapper.select());
    }

    @RequestMapping(value = "shopList/shopContractLog", method = RequestMethod.GET)
    public void queryShopContractLog(@RequestParam @Valid @NotBlank String shopSeq) {
        System.out.println(shopSeq);
    }

}
