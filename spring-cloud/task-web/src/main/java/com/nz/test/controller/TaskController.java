package com.nz.test.controller;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author nz
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String addTask() {
        return UUID.randomUUID().toString();
    }

}
