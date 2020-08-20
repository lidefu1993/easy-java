package com.ldf.easy;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ldf.easy.jackson.MyDateSerializer;
import com.ldf.easy.jackson.MyNumberSerializer;
import com.ldf.easy.jackson.MyObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import com.fasterxml.jackson.core.Version;
/**
 * @author lidefu
 * @date 2020年06月09日20:27
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.ldf.easy.mybatis"})
public class TestApp implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(TestApp.class);
    }

    @Autowired
    private MyObjectMapper myObjectMapper;

    @Override
    public void run(String... strings) throws Exception {
        SimpleModule dotNetModule = new SimpleModule("MyDateSerializer", new Version(1, 0, 0, null));
        dotNetModule.addSerializer(Date.class, new MyDateSerializer());
        myObjectMapper.registerModule(dotNetModule);

        SimpleModule dotNetModule2 = new SimpleModule("MyDateSerializer2", new Version(1, 0, 0, null));
        dotNetModule.addSerializer(Number.class, new MyNumberSerializer(Number.class));
        myObjectMapper.registerModule(dotNetModule2);
    }
}
