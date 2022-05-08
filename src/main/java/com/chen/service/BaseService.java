package com.chen.service;

import com.chen.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    public void update(){
        baseDao.update();
    }
}
