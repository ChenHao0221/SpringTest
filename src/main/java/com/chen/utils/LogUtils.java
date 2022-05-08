package com.chen.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 如何将这个类（切面类）中的这些方法（通知方法）动态地在目标方法运行地各个位置切入
 */
@Aspect
@Component
public class LogUtils {

    /**
     * 抽取可重用切入点表达式
     * 1、随便声明一个没有实现的返回void的空方法
     * 2、给方法上标注@Pointcut注解
     */
    @Pointcut("execution(public int com.chen.impl.MyCalculator.*(int, int))")
    public void hahaMyPoint(){}

    /**
     * 告诉Spring每个方法都什么时候运行
     */
    //切入点表达式：execution(访问权限符 返回值类型 方法签名(方法全类名+参数列表))
    @Before("hahaMyPoint()")
    public static void logStart(JoinPoint joinPoint){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【"+name+"】开始执行，参数列表【"+ Arrays.asList(args) +"】");
    }

    @AfterReturning(value = "hahaMyPoint()", returning = "result")
    public static void logReturn(JoinPoint joinPoint, Object result){  //加一个参数Object result来接收返回值(Object的目的就是为了能够接收所有返回值)
        System.out.println("【"+joinPoint.getSignature().getName()+"】开始执行，计算结果【"+result+"】");
    }

    @AfterThrowing(value = "hahaMyPoint()", throwing = "exception")
    public static void logException(JoinPoint joinPoint, Exception exception){  //Exception是为了能够接收所有的异常
        System.out.println("【"+joinPoint.getSignature().getName()+"】执行出现异常，异常信息【"+exception+"】");
    }

    @After("hahaMyPoint()")
    public static void logEnd(JoinPoint joinPoint){
        System.out.println("【"+joinPoint.getSignature().getName()+"】方法最终结束");
    }

    /**
     * 环绕通知，相当于就是一个动态代理
     * proceed = pjp.proceed(args);就是执行method.invoke(obj, args)
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("hahaMyPoint()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        String name = pjp.getSignature().getName();

        Object proceed = null;
        try {
            System.out.println("环绕前置");
            //利用反射调用目标方法即可，就是method.invoke(obj, args)
            proceed = pjp.proceed(args);
            System.out.println("环绕返回");
        } catch (Exception e) {
            System.out.println("环绕异常");
            //为了让外界能知道这个异常，这个异常一定要抛出去
            throw new RuntimeException(e);
        } finally {
            System.out.println("环绕后置");
        }
        //反射调用后的返回值也一定返回出去
        return proceed;
    }
}
