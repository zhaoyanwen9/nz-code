package com.nz.test;

import com.nz.test.hystrix.TaskHystrix;
import com.nz.test.hystrix.TaskHystrix2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * value ---> 指定调用哪个服务;fallbackFactory---> 熔断器的降级提示
 */
@FeignClient(name = "task-web", fallback = TaskHystrix.class)
// @FeignClient(value = "task-web", configuration = FeignClientsConfiguration.class, fallbackFactory = TaskHystrix2.class)
public interface TaskFeign {

    /**
     * 采用Feign我们可以使用SpringMVC的注解来对服务进行绑定
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/task/getByRp", method = {RequestMethod.GET})
    String getByRp(@RequestParam(value = "page") int page,
                   @RequestParam(value = "size") int size);
}
