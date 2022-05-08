package com.chen.dao;

import org.springframework.stereotype.Repository;

public abstract class BaseDao<T> {
    public abstract void update();
}
