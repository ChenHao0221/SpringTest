package com.chen.bean;

import com.chen.inter.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    ApplicationContext ioc ;

    @Test
    public void test(){
        ioc = new ClassPathXmlApplicationContext("aop.xml");
        //从容器中拿到目标对象(如果想要用类型获取，一定要用他的接口类型，不要用本类)
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(2,1);
    }

}
