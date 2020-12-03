package com.nz.test.service;

import com.nz.test.domain.Task;
import com.nz.test.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public Task getById(int id) {
        return taskMapper.getById(id);
    }
}
