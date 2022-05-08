package com.chen.bean;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class HelloWorldTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test() throws Exception
    {
        /**
         * 1.加载Spring的配置文件
         * 2.取出Bean容器中的实例
         * 3.调用bean方法
         */
        // 1.加载Spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        // 2.取出Bean容器中的实例
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        // 3.调用bean方法
        helloWorld.helloWorld();
    }
}
