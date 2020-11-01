package com.nz.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "task-web")
public interface TaskFeign {

    @RequestMapping(value = "/task/add", method = {RequestMethod.GET})
    String add();
}
