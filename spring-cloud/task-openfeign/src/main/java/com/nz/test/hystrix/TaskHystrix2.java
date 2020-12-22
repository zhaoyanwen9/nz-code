package com.nz.test.hystrix;

import com.nz.test.TaskFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class TaskHystrix2 implements FallbackFactory<TaskFeign> {

    @Override
    public TaskFeign create(Throwable throwable) {
        return new TaskFeign() {
            @Override
            public String getByRp() {
                return "呦西!!!";
            }
        };
    }
}
