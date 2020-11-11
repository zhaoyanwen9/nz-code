package com.nz.test.dao.impl;

import com.nz.test.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDaoRepository extends JpaRepository<TaskEntity, Integer> {

    Page<TaskEntity> findAll(Specification<TaskEntity> spec, Pageable pageable);
}
