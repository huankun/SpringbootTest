package com.bnuz.entry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bnuz")
@MapperScan("com.bnuz.mapper")
public class SqldataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqldataApplication.class, args);
    }

}
