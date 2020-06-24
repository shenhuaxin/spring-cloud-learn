package com.springcloud.learn.jpalearn.rest;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelData {



    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private String age;
}
