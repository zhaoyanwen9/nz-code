package com.nz.test.controller;

import com.nz.test.async.AsyncTask;
import com.nz.test.entity.TaskEntity;
import com.nz.test.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author nz
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String addTask() {
        return UUID.randomUUID().toString();
    }

    /**
     * 异步调用:
     *     @Async
     *     @EnableAsync
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/taskService")
    public String doTask() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();
        long end = System.currentTimeMillis();
        System.out.println("任务总耗时：" + (end - start) + "ms");
        return "任务总耗时：" + (end - start) + "ms";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public String add() {
        TaskEntity taskEntity = new TaskEntity(UUID.randomUUID().toString());
        return taskService.add(taskEntity);
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public String deleteById() {
        return taskService.deleteById();
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.POST})
    public String editById(@RequestParam("id") int id) {
        TaskEntity taskEntity = new TaskEntity(id, UUID.randomUUID().toString());
        return taskService.editById(taskEntity);
    }

    @RequestMapping(value = "/get_all", method = {RequestMethod.GET})
    public String getAll() {
        return taskService.getAll();
    }

    @RequestMapping(value = "/get_by_rp", method = {RequestMethod.GET})
    public String getByRp() {
        return taskService.getByRp();
    }

    @RequestMapping(value = "/get_by_id/{id}", method = {RequestMethod.GET})
    public String getById(@PathVariable int id) {
        return taskService.getById(id);
    }

    @RequestMapping(value = "/start", method = {RequestMethod.GET})
    public String startById() {
        return taskService.startById();
    }

    @RequestMapping(value = "/stop", method = {RequestMethod.GET})
    public String stopById() {
        return taskService.stopById();
    }

    @RequestMapping(value = "/retry", method = {RequestMethod.GET})
    public String retry() {
        System.err.println("client 1 call ...........");
        ///client 睡眠 6s 超过了配置的响应等待3s
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "client 1";
    }
}
