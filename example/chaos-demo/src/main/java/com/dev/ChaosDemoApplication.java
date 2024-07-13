package com.dev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.dev.demo.**.dao*"} )
public class ChaosDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChaosDemoApplication.class, args);
    }
}