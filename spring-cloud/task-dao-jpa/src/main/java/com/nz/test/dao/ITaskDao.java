package com.nz.test.dao;

public interface ITaskDao {

    /**
     * 分页查询
     *
     * @return
     */
    public String getByRp(int page_num, int page_size);

}
