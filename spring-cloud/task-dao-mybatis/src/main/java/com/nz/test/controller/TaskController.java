package com.nz.test.controller;

import com.nz.test.domain.Task;
import com.nz.test.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/{id}")
    public Task getById(@PathVariable int id) {
        return taskService.getById(id);
    }
}
