package com.nb.wukong.utils.aop;

import com.nb.wukong.utils.anno.PrintTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义切面
 */
@Aspect
@Component
public class PrintTimeAspect {

    @Around("@annotation(printTime)")
    public Object around(ProceedingJoinPoint joinPoint, PrintTime printTime)throws Throwable{

        System.out.println("方法开始时间是:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Object o = joinPoint.proceed();
        System.out.println("方法结束时间是:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())) ;
        return o;
    }
}
