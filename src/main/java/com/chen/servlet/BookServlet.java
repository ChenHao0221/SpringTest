package com.chen.servlet;

import com.chen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 属性的自动注入
 */
@Controller
public class BookServlet {

    /**
     * 自动装配，自动为这个属性赋值
     */
    @Autowired
    private BookService bookService;

    public void doGet(){
        bookService.update();
    }
}
