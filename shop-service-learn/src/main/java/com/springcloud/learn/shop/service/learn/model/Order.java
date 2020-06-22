package com.springcloud.learn.shop.service.learn.model;

//import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Order {


    @NotNull
    @NotBlank
    private String name;

    private Integer age;


//    @JSONField(format = "yyyy-MM-dd HH", name = "Data123")
    private Date date;

}
