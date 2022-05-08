package com.chen.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class dataSourceTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test() throws SQLException {
        //1、从容器中拿到连接池
//        DataSource dataSource = (DataSource) ioc.getBean("dataSource");
        //2、按照类型获取，可有获取到这个类型下的所有实现类子类等等
        DataSource dataSource = ioc.getBean(DataSource.class);

        System.out.println(dataSource.getConnection());
    }
}
