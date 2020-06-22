package com.springcloud.learn.jpalearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springcloud.learn.jpalearn.mapper")
public class JpaLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaLearnApplication.class, args);
    }

}
