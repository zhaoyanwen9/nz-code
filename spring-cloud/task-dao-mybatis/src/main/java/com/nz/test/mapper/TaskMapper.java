package com.nz.test.mapper;

import com.nz.test.domain.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskMapper {

    Task getById(int id);
}
