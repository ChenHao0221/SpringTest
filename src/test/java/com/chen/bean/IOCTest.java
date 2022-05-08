package com.chen.bean;

import com.chen.service.BookService;
import com.chen.service.UserService;
import com.chen.servlet.BookServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class IOCTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    ApplicationContext ioc2 = new ClassPathXmlApplicationContext("applicationContext2.xml");
    ApplicationContext ioc3 = new ClassPathXmlApplicationContext("applicationContext3.xml");

    /**
     * 测试基于XML的自动装配
     */
    @Test
    public void test() {
        ioc.getBean(Person.class);
    }

    @Test
    public void test02() {
        Person person02 = (Person) ioc.getBean("person02");
        System.out.println(person02);
    }

    @Test
    public void test03() {
        Object bookDao = ioc2.getBean("bookDao");
        System.out.println(bookDao);
    }

    @Test
    public void test04() {
        BookServlet bookServlet = ioc2.getBean(BookServlet.class);
        bookServlet.doGet();
    }

    @Test
    public void test05() {
        BookService bookService = ioc3.getBean(BookService.class);
        UserService userService = ioc3.getBean(UserService.class);
        bookService.update();
        userService.update();
    }

}
