package com.nz.test.controller;

import com.nz.test.TaskFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 任务负载
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskFeign taskFeign;

    @GetMapping(value = "/getByRp")
    public String getByRp(@RequestParam(value = "page") int page,
                          @RequestParam(value = "size") int size) {
        String result = taskFeign.getByRp(page, size);
        logger.info("#### {} {} {}", page, size, result);
        return result;
    }
}
