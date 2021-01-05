package com.nz.test.service;

import com.google.gson.Gson;
import com.nz.test.entity.TaskEntity;
import com.nz.test.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskService {

    private Gson gson = new Gson();

    @Autowired
    private TaskMapper taskMapper;

    public int getCount() {
        return taskMapper.getCount();
    }

    public Map<String, Object> getCruxInfo(int id) {
        return taskMapper.getCruxInfo(id);
    }

    // @Transactional(rollbackFor = Throwable.class)
    public String getById(int id) {
        TaskEntity task = taskMapper.getById(id);
        return gson.toJson(task);
    }

    public String getByRp(int page, int size) {
        List<TaskEntity> taskList = taskMapper.getByRp(page, size);
        return gson.toJson(taskList);
    }

    public List<Map<String, Object>> getAll() {
        return taskMapper.getAll();
    }
}
