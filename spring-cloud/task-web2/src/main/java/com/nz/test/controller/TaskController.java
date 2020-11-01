package com.nz.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public String add() {
        return UUID.randomUUID().toString()+"-2";
    }
}
