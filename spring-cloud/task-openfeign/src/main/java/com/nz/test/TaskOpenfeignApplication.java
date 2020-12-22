package com.nz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author nz
 * @EnableEurekaClient 注册中心是eureka
 * @EnableDiscoveryClient 注册中心非eureka, consul、zookeeper
 */
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix //开启Hystrix支持
@SpringBootApplication
public class TaskOpenfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskOpenfeignApplication.class, args);
    }

}
