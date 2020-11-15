package com.springcloud.learn.api;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Goods {
    private Long id;
    private String name;
    private BigDecimal price;
    private Long version;


}
