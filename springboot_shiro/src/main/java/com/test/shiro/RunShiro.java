package com.test.shiro;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.test.shiro.mapper")
public class RunShiro {
    public static void main(String[] args) {
        SpringApplication.run(RunShiro.class,args);
    }
}
