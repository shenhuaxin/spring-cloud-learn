package com.springcloud.learn.controller;

import com.springcloud.learn.api.Goods;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@Slf4j
public class ShopController {

//    private String ZUUL_GATEWAY_LEARN = "http://zuul-gateway-learn/";

    private String USER_SERVICE_URL = "http://127.0.0.1:8093";

    private String ORDER_SERVICE_URL = "http://127.0.0.1:8085";

    private String GOODS_SERVICE_URL = "http://127.0.0.1:8084";


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("buy")
    public String buy() {
        return buyphone();
    }

    @GlobalTransactional
    public String buyphone() {
        log.info("开始全局事务，XID = " + RootContext.getXID());

        Goods goods = restTemplate.getForObject(GOODS_SERVICE_URL+"/getGoodsDetail", Goods.class);
        Long goodsId = goods.getId();
        BigDecimal goodsPrice = goods.getPrice();
        // 创建订单
        String createOrder = restTemplate.getForObject( ORDER_SERVICE_URL + "/createOrder" + "?userId={1}&goodsId={2}", String.class, 1L, goodsId);
        System.out.println(createOrder);
        // 扣款
        String debit = restTemplate.getForObject(USER_SERVICE_URL + "/debit?accountId={1}&money={2}", String.class, 1L, goodsPrice);
        System.out.println(debit);
        return "下单成功";
    }

}
