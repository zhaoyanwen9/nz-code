package com.nz.test.controller;

import com.nz.test.TaskFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/feign-task")
public class TaskController {

    @Autowired
    private TaskFeign taskFeign;

    @GetMapping(value = "/getByRp")
    public String getByRp(@RequestParam int page, @RequestParam int size, @RequestParam String name) {
        return taskFeign.getByRp(page, size, name);
    }
}
