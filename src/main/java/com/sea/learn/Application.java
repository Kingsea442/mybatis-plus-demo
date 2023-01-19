package com.sea.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/1/18 10:11
 */
@SpringBootApplication
@MapperScan("com.sea.learn.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
