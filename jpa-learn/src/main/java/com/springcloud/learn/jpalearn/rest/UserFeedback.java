package com.springcloud.learn.jpalearn.rest;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
//import com.alibaba.excel.annotation.write.style.ContentStyle;
import lombok.Data;
import org.apache.poi.ss.usermodel.BorderStyle;

@Data
public class UserFeedback {

    @ExcelProperty("序号")
//    @ContentStyle(borderTop = BorderStyle.THIN, borderBottom = BorderStyle.THIN, borderLeft = BorderStyle.THIN, borderRight = BorderStyle.THIN)
    private String index;

//    @ExcelIgnore
//    private Integer hasDriverLicense;

    @ExcelProperty("有无驾照")
//    @ContentStyle(borderTop = BorderStyle.THIN, borderBottom = BorderStyle.THIN, borderLeft = BorderStyle.THIN, borderRight = BorderStyle.THIN)
    private String hasDriverLicenseStr;

//    @ExcelIgnore
//    private Integer driverLicenseNoExpire;

    @ExcelProperty("驾驶证有效期")
//    @ContentStyle(borderTop = BorderStyle.THIN, borderBottom = BorderStyle.THIN, borderLeft = BorderStyle.THIN, borderRight = BorderStyle.THIN)
    private String driverLicenseNoExpireStr;

    @ExcelProperty("驾驶证状态")
    private String driver_license_is_validity;
    @ExcelProperty("违法次数")
    private String driver_license_has_violation;
    @ExcelProperty("名下新能源车")
    private String has_new_energy_vehicle;
    @ExcelProperty("有无处罚")
    private String has_punish;

    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("证件名称")
    private String idCardName;
    @ExcelProperty("证件号")
    private String idCardNo;
    @ExcelProperty("驾驶证发证地")
    private String driver_license_issuing_place;
    @ExcelProperty("驾驶证发证单位")
    private String driver_license_issuing_organization;
    @ExcelProperty("驾驶证证号")
    private String driver_license_code;
    @ExcelProperty("开始日期")
    private String startTime;
    @ExcelProperty("终止日期")
    private String endTime;
}

