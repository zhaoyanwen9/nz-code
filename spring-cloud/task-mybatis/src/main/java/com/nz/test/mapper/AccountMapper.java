package com.nz.test.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    /**
     * 转入
     * @param id
     * @param money
     */
    void moveIn(@Param("id") int id, @Param("money") float money);

    /**
     * 转出
     * @param id
     * @param money
     */
    void moveOut(@Param("id") int id, @Param("money") float money);

}
