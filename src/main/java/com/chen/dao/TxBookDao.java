package com.chen.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TxBookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    /**
     * 减余额
     */
    public void updateBalance(String userName, int price){
        String sql = "UPDATE account SET balance=balance-? WHERE username=?";
        jdbcTemplate.update(sql, price, userName);

    }

    /**
     * 获取某本图书的价格
     * @return
     */
    public int getPrice(String isbn){
        String sql = "SELECT price FROM book WHERE isbn=?";
        //第二个参数表示查询到的结果封装成Integer类型返回
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    /**
     * 减库存
     */
    public void updateStock(String isbn){
        String sql = "UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
        jdbcTemplate.update(sql, isbn);
    }
}
