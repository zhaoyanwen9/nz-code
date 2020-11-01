package com.nz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TaskWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskWebApplication.class, args);
	}

}
