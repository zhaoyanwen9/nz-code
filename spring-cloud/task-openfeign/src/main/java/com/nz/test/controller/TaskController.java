package com.nz.test.controller;

import com.nz.test.TaskFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskFeign taskFeign;

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public String start() {
        return taskFeign.add();
    }
}
