package com.nz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TaskWeb2Application {

	public static void main(String[] args) {
		SpringApplication.run(TaskWeb2Application.class, args);
	}

}
