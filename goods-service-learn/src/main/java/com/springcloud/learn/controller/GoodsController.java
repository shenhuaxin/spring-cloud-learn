package com.springcloud.learn.controller;

import com.springcloud.learn.entity.Goods;
import com.springcloud.learn.repository.GoodsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GoodsController {

    @Value("${eureka.instance.instance-id}")
    private String port;

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("getGoodsDetail")
    public Goods getGoodsDetail() {
        Goods one = goodsRepository.getOne(1L);
        Goods goods = new Goods();
        BeanUtils.copyProperties(one, goods);
        return goods;
    }

}
