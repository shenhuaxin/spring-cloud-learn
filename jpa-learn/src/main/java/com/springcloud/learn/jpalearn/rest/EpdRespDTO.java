package com.springcloud.learn.jpalearn.rest;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * {
 * body=
 * [
 * {cllb=QH,
 * clsbdh=LVGBY8090KG008685,
 * clxh=GTM7180LCHEVM,
 * clxhhb=GTM7180LCHEVM,
 * fdjxh=8ZR,
 * pf=6b,
 * prefixLen=0,
 * rzlb=1,
 * suffixLen=0,
 * tableName=,
 * zt=3}
 * ],
 * code=1,
 * exchangeType=21,
 * responseTime=2020-06-22 14:49:06,
 * version=1.0.1
 * }
 *
 * VehicleEpdInfo
 */

@Data
public class EpdRespDTO {


    private List<VehicleEpdInfo> body;

    private Integer code;

    private Integer exchangeType;

    private String responseTime;

    private String version;

}
