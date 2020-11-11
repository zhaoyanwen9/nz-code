package com.nz.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "task-web")
public interface TaskFeign {

    @RequestMapping(value = "/task/getByRp", method = {RequestMethod.GET})
    String getByRp(@RequestParam int page, @RequestParam int size, @RequestParam String name);
}
