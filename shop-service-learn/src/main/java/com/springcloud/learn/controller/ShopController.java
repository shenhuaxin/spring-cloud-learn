package com.springcloud.learn.controller;

import com.springcloud.learn.api.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@Slf4j
public class ShopController {

    private String ZUUL_GATEWAY_LEARN = "http://zuul-gateway-learn/";

    private String USER_SERVICE_URL = "user-service";

    private String ORDER_SERVICE_URL = "order-service";

    private String GOODS_SERVICE_URL = "goods-service";


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("buy")
    public String buy() {
        Goods goods = restTemplate.getForObject(ZUUL_GATEWAY_LEARN + GOODS_SERVICE_URL+"/getGoodsDetail", Goods.class);
        Long goodsId = goods.getId();
        BigDecimal goodsPrice = goods.getPrice();
        // 创建订单
        String forObject = restTemplate.getForObject(ZUUL_GATEWAY_LEARN + ORDER_SERVICE_URL + "/createOrder" + "?userId={1}&goodsId={2}", String.class, 1L, goodsId);
        // 扣款
        String forObject1 = restTemplate.getForObject(ZUUL_GATEWAY_LEARN + USER_SERVICE_URL + "/debit?accountId={1}&money={2}", String.class, 1L, goodsPrice);

        return "下单成功";
    }

}
