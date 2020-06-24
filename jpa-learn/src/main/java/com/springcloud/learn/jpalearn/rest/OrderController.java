package com.springcloud.learn.jpalearn.rest;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.springcloud.learn.jpalearn.mapper.OrderMapper;
import com.springcloud.learn.jpalearn.mapper.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;



    @GetMapping(value = "download")
    public ResponseEntity<byte[]> download() throws Exception {
        System.out.println("download");

        // 写法1
        String fileName = "C:\\Users\\dell\\Desktop\\" + "simpleWrite" + System.currentTimeMillis() + ".xls";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, UserFeedback.class).sheet("模板").doWrite(data());

        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] buff = new byte[fileInputStream.available()];
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename="+"1.xlsx");

        fileInputStream.read(buff);
        fileInputStream.close();
        return new ResponseEntity<byte[]>(buff, headers, HttpStatus.OK);
    }




//
    @RequestMapping(value = "upload")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {

//        // 写法1
//        String fileName = "C:\\Users\\dell\\Desktop\\" + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        // 如果这里想使用03 则 传入excelType参数即可
//        EasyExcel.write(fileName, ExcelData.class).sheet("模板").doWrite(data());


        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭

//        System.out.println(file.isEmpty());
//        System.out.println(file.getName());
//        System.out.println(file.getSize());
//        System.out.println(file.getBytes());
//
//
        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());

        Sheet sheet = workbook.getSheetAt(0);
        //获取总行数
        int rows = sheet.getPhysicalNumberOfRows();
        //去除表头，从第 1 行开始打印
        for (int i = 0; i < rows; i++) {
            Row row = sheet.getRow(i);
            //获取总列数
            int cols = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cols; j++) {
                System.out.print(row.getCell(j) + "\t");
            }
            System.out.println();
        }


    }

    @GetMapping(value = "userFeedback")
    public ResponseEntity<byte[]> userFeedback() throws Exception {


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        EasyExcel.write(outputStream, UserFeedbackDTO.class).withTemplate(ExcelUtil.EXCEL_PATH).sheet().doWrite(data());
        EasyExcel.write(outputStream, UserFeedback.class).withTemplate(ExcelUtil.EXCEL_PATH).sheet("外地").doFill(data());

        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename="+ System.currentTimeMillis() +".xlsx");
        headers.add("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        byte[] bytes = outputStream.toByteArray();
        outputStream.close();
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "uploadExcel")
    public void uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("uploadExcel");
        EasyExcel.read(file.getInputStream(), UserFeedback.class, new ReadListener<UserFeedback>() {
            @Override
            public void onException(Exception exception, AnalysisContext context) throws Exception {

            }
            @Override
            public void invokeHead(Map headMap, AnalysisContext context) {
                System.out.println(headMap);
            }

            @Override
            public void invoke(UserFeedback data, AnalysisContext context) {
                System.out.println(data);
            }

            @Override
            public void extra(CellExtra extra, AnalysisContext context) {

            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println("打印完了");
            }

            @Override
            public boolean hasNext(AnalysisContext context) {
                return true;
            }
        }).headRowNumber(2).sheet(1).doRead();

    }

    public static List<UserFeedback> data() {
        List<UserFeedback> list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            UserFeedback userFeedback = new UserFeedback();
            userFeedback.setIndex("1");
            userFeedback.setHasDriverLicenseStr("1");
            userFeedback.setDriverLicenseNoExpireStr("1");
            userFeedback.setDriver_license_is_validity("1");
            userFeedback.setDriver_license_has_violation("1");
            userFeedback.setHas_new_energy_vehicle("1");
            userFeedback.setHas_punish("1");
            userFeedback.setName("1");
            userFeedback.setIdCardName("1");
            userFeedback.setIdCardNo("1");
            userFeedback.setDriver_license_issuing_place("1");
            userFeedback.setDriver_license_issuing_organization("1");
            userFeedback.setDriver_license_code("1");
            userFeedback.setStartTime("1");
            userFeedback.setEndTime("1");
            list.add(userFeedback);
//            list.add(new ExcelData("name"+i, "age"+i));
        }
        return list;
    }




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



    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "test1")
    public void test1() throws UnsupportedEncodingException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://www.shvehicle.cn/shvehicle/work/ex/query.do?jkbs={jkbs}&jkjswybs={jkjswybs}&jkyhm={jkyhm}&jksqm={jksqm}&crcCode={crcCode}&jsonData={jsonData}";

        Map<String, String> map = new HashMap<>();
        map.put("jkbs", "TTYWTBSHHBJKR001");
        map.put("jkjswybs", "4");
        map.put("jkyhm", "YWTB");
        map.put("jksqm", "YWTB1234");
        map.put("jsonData", "{\"exchangeType\":\"20\",\"exchangeCode\":"+System.currentTimeMillis()+",\"requestTime\":\"20170304050607\",\"body\":[{\"VIN\":\""+"LVGBY8090KG008685"+"\"}],\"version\":\"1.0.1\"}");

        map.put("crcCode", CodeUtil.checkCRCNew(map.get("jsonData")));

        Object forObject = restTemplate.getForObject(url,Object.class, map);

        System.out.println(forObject);
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://www.shvehicle.cn/shvehicle/work/ex/query.do?jkbs={jkbs}&jkjswybs={jkjswybs}&jkyhm={jkyhm}&jksqm={jksqm}&crcCode={crcCode}&jsonData={jsonData}";

        Map<String, String> map = new HashMap<>();
        map.put("jkbs", "TTYWTBSHHBJKR001");
        map.put("jkjswybs", "4");
        map.put("jkyhm", "YWTB");
        map.put("jksqm", "YWTB1234");
        map.put("jsonData", "{\"exchangeType\":\"20\",\"exchangeCode\":"+System.currentTimeMillis()+",\"requestTime\":\"20170304050607\",\"body\":[{\"VIN\":\""+"LVGBY8090KG008685"+"\"}],\"version\":\"1.0.1\"}");

        map.put("crcCode", CodeUtil.checkCRCNew(map.get("jsonData")));

        EpdRespDTO forObject = restTemplate.getForObject(url, EpdRespDTO.class, map);

        System.out.println(forObject);
    }





}
