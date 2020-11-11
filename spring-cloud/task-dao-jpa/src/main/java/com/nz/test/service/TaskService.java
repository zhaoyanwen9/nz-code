package com.nz.test.service;

import com.nz.test.dao.impl.TaskDaoRepository;
import com.nz.test.entity.TaskEntity;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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

    public String getByRp(int page, int size, String name) {
        //规格定义
        Specification<TaskEntity> specification = new Specification<TaskEntity>() {
            @Override
            public Predicate toPredicate(Root<TaskEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if (StringUtils.isNotBlank(name)) { //添加断言
                    Predicate likeNickName = criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%");
                    predicates.add(likeNickName);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
        //分页信息
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        //查询
        Page<TaskEntity> entityPage = taskDaoRepository.findAll(specification, pageRequest);
        return new Gson().toJson(entityPage);
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
