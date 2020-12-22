package com.nz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author nz
 * @EnableEurekaServer - 激活eureka服务器相关配置
 * EurekaServerMarkerConfiguration
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMasterApplication.class, args);
    }

}
