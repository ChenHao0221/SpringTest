package com.chen.dao;

import com.chen.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {
    @Override
    public void update() {
        System.out.println("更新用户");
    }
}
