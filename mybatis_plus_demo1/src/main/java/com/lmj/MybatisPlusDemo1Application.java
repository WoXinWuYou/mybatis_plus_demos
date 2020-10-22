package com.lmj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lmj.mapper")
public class MybatisPlusDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDemo1Application.class, args);
    }

}
