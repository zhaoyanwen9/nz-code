package com.nz.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

@ServletComponentScan
@ImportResource(locations = {"classpath:config/druid/druid-bean.xml"})
@MapperScan("com.nz.test.mapper")
@SpringBootApplication
public class TaskDaoMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskDaoMybatisApplication.class, args);
    }

}
