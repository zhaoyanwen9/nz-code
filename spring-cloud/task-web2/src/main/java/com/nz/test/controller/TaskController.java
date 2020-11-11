package com.nz.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/getByRp", method = {RequestMethod.GET})
    public String getByRp(@RequestParam(value = "page") int page,
                          @RequestParam(value = "size") int size,
                          @RequestParam(value = "name") String name) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("task-dao-jpa");
        String url = String.format("http://%s:%s/task/getByRp?page="+page+"&size="+size+"&name="+name, serviceInstance.getHost(), serviceInstance.getPort());
        String result = restTemplate.getForObject(url, String.class, page, size, name);
        return result;
    }
}
