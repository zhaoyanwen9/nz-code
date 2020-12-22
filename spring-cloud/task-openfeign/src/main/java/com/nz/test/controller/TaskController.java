package com.nz.test.controller;

import com.nz.test.TaskFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskFeign taskFeign;

    @GetMapping(value = "/getByRp")
    public String getByRp() {
        String result = taskFeign.getByRp();
        return result;
    }
}
