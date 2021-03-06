package com.ldf.easy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lidefu
 * @date 2020年06月09日20:27
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.ldf.easy.dao"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

}
