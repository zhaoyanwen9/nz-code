package com.nz.test;

import com.nz.test.hystrix.TaskHystrix;
import com.nz.test.hystrix.TaskHystrix2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

// @FeignClient(name = "task-web")
@FeignClient(name = "task-web", fallback = TaskHystrix.class)
// @FeignClient(value = "task-web", configuration = FeignClientsConfiguration.class, fallbackFactory = TaskHystrix2.class)
public interface TaskFeign {

    @RequestMapping(value = "/task/getByRp", method = {RequestMethod.GET})
    String getByRp(@RequestParam(value = "page") int page,
                   @RequestParam(value = "size") int size);
}
