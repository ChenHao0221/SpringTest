package com.chen.bean;

import com.chen.servlet.BookServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Spring的单元测试
 * 1、导包，Spring单元测试包
 * 2、@ContextConfiguration(location="")使用它来指定Spring的配置文件
 * 3、@RunWith()指定用哪种驱动进行单元测试，默认是junit
 *    @RunWith(SpringJUnit4ClassRunner.class)使用Spring的单元测试模块来执行标了@Test注解的测试方法 (以前@Test注解是由junit执行的)
 */
@ContextConfiguration(locations = "classpath:applicationContext2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringUnitTest {

    @Autowired
    BookServlet bookServlet;

    @Test
    public void test(){
        System.out.println(bookServlet);
    }
}
