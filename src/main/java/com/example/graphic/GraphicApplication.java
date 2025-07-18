package com.example.graphic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.graphic.mapper")
public class GraphicApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphicApplication.class, args);
    }

}
