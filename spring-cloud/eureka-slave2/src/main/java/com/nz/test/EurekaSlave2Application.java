package com.nz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaSlave2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaSlave2Application.class, args);
	}

}
