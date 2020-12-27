package com.nz.test.hystrix;

import com.nz.test.TaskFeign;
import org.springframework.stereotype.Component;

@Component
public class TaskHystrix implements TaskFeign {

    @Override
    public String getByRp(int page, int size) {
        return "服务有问题";
    }
}
