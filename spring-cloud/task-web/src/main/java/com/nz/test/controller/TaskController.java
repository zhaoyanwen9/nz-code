package com.nz.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

/**
 * @author nz
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String addTask() {
        return UUID.randomUUID().toString();
    }

    @RequestMapping(value = "/getByRp", method = {RequestMethod.GET})
    public String getTaskByRp() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("task-dao-jpa");
        String url = "http://%s:%s/task/getByRp";
        String urlFormat = String.format(url, serviceInstance.getHost(), serviceInstance.getPort());
        String result = restTemplate.getForObject(urlFormat, String.class);
        logger.info("{} {}", urlFormat, result);
        return result;
    }

}
