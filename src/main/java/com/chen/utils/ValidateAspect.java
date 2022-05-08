package com.chen.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ValidateAspect {

    @Before("com.chen.utils.LogUtils.hahaMyPoint()") //引入外部的切入点表达式
    public void logStart(JoinPoint joinPoint){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【"+name+"】开始执行，参数列表【"+ Arrays.asList(args) +"】");
    }

    @AfterReturning(value = "com.chen.utils.LogUtils.hahaMyPoint()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result){  //加一个参数Object result来接收返回值(Object的目的就是为了能够接收所有返回值)
        System.out.println("【"+joinPoint.getSignature().getName()+"】开始执行，计算结果【"+result+"】");
    }

    @AfterThrowing(value = "com.chen.utils.LogUtils.hahaMyPoint()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception){  //Exception是为了能够接收所有的异常
        System.out.println("【"+joinPoint.getSignature().getName()+"】执行出现异常，异常信息【"+exception+"】");
    }

    @After("com.chen.utils.LogUtils.hahaMyPoint()")
    public static void logEnd(JoinPoint joinPoint){
        System.out.println("【"+joinPoint.getSignature().getName()+"】方法最终结束");
    }
}
