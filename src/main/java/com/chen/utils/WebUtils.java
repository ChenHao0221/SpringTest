package com.chen.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class WebUtils {
    public static <T>T getBean(Class<T> clazz){
        //获取ioc容器
        WebApplicationContext ioc = ContextLoader.getCurrentWebApplicationContext();
        return ioc.getBean(clazz);
    }
}
