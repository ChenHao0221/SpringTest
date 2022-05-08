package com.chen.dao;

import com.chen.bean.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book> {

    public void saveBook(){
        System.out.println("保存图书");
    }

    @Override
    public void update() {
        System.out.println("更新图书");
    }
}
