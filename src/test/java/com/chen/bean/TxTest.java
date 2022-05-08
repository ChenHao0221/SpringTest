package com.chen.bean;

import com.chen.service.TxBookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");

    @Test
    public void test(){
        TxBookService bookService = ioc.getBean(TxBookService.class);
        bookService.checkout("Tom","ISBN-001");
        System.out.println("结账完成");
    }
}
