package com.springcloud.learn.jpalearn.rest;

public class ExcelUtil {

    private static final String CLASSPATH;

    static {
        CLASSPATH = ClassLoader.getSystemResource("").getPath();
    }

    public static final String EXCEL_PATH = CLASSPATH + "excel/意向用户.xlsx";


    public static void main(String[] args) {
        System.out.println(EXCEL_PATH);
    }
}
