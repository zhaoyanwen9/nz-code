package com.nz.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nz.test.dao.mapper.*")
public class ShiroDriudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiroDriudApplication.class, args);
	}

}
