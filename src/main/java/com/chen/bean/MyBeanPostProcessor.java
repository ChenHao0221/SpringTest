package com.chen.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 1、编写后置处理器的实现类
 * 2、将后置处理器注册在配置文件中
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * Object bean就是将要初始化的bean
     * String beanName就是bean在xml中配置的id
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "bean将要调用初始化方法");

        //返回传入的bean
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "bean已经要调用初始化方法");

        //初始化之后返回的bean，返回的是什么，容器中保存的就是生命
        return bean;
    }
}
