package com.nz.test.dao.impl;

import com.nz.test.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDaoRepository extends JpaRepository<TaskEntity, Integer> {
}
