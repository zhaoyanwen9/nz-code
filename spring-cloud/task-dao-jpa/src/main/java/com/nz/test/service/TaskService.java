package com.nz.test.service;

import com.nz.test.dao.impl.TaskDaoRepository;
import com.nz.test.entity.TaskEntity;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private Gson gson = new Gson();

    @Autowired
    private TaskDaoRepository taskDaoRepository;

    public String add(TaskEntity taskEntity) {
        return gson.toJson(taskDaoRepository.save(taskEntity));
    }

    public String deleteById() {
        return "delete by id";
    }

    public String editById(TaskEntity taskEntity) {
        return gson.toJson(taskDaoRepository.save(taskEntity));
    }

    public String getByRp() {
        return "get by rp";
    }

    public String getById(int id) {
        return gson.toJson(taskDaoRepository.findById(id));
    }

    public String getAll() {
        return gson.toJson(taskDaoRepository.findAll());
    }

    public String startById() {
        return "start";
    }

    public String stopById() {
        return "stop by id";
    }

}
