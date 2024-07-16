package com.lcd.bloggingsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lcd.bloggingsystem.mapper")
public class BloggingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloggingSystemApplication.class, args);
    }

}
