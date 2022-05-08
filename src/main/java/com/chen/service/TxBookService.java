package com.chen.service;

import com.chen.dao.TxBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxBookService {
    @Autowired
    TxBookDao txBookDao;

    @Transactional
    public void checkout(String username, String isbn){
        txBookDao.updateStock(isbn);

        int price = txBookDao.getPrice(isbn);
        txBookDao.updateBalance(username, price);
    }
}
