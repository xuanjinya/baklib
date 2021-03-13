package com.zfkj.baklib;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.zfkj.baklib.mapper")
@EnableCaching
public class BaklibApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaklibApplication.class, args);
    }

}
