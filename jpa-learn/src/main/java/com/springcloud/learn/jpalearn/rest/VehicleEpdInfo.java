package com.springcloud.learn.jpalearn.rest;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VehicleEpdInfo {

    /**
     * 车辆类别
     */
    @JsonProperty("cllb")
    private String vehicleType;

    /**
     * 车辆识别代号(VIN码， 车架号)
     */
    @JsonProperty("clsbdh")
    private String vin;

    /**
     * 车辆型号
     */
    @JsonProperty("clxh")
    private String vehicleModel;

    /**
     * 车辆环保型号
     */
    @JsonProperty("clxhhb")
    private String vehicleModelEpd;

    /**
     * 发动机型号
     */
    @JsonProperty("fdjxh")
    private String engineModel;

    /**
     * 排放阶段
     */
    @JsonProperty("pf")
    private String emissionLevel;

    /**
     * 认证类别（新车/转入车）
     */
    @JsonProperty("rzlb")
    private String authType;

    /**
     * 认证状态
     */
    @JsonProperty("zt")
    private String authStatus;


}
