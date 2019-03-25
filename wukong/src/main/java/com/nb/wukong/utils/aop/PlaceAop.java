package com.nb.wukong.utils.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
/**
 *
 * 注解说明
 * @Aspect : 表明该类是一个切面类
 * @Pointcut ： 切入点 execution - 用于连接切入面
 *
 *--------------------------------------------------------------------------------------
 * Place 切面
 */
@Aspect
@Component
public class PlaceAop {

    /**
     * 切入点 execution - 用于连接切入面
     */
    @Pointcut("execution(public * com.nb.wukong.controller.PlaceController.*(..))")
    public void doAspect(){
    }

    /**
     * 方法执行前执行
     */
    @Before("doAspect()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("PlaceAop 方法执行前执行");
    }

    /**
     * 方法执行后执行
     */
    @After("doAspect()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("PlaceAop 方法执行后执行");
    }

    /**
     * 有结果返回时执行
     */
    @AfterReturning("doAspect()")
    public void doAfterReturning(JoinPoint joinPoint){
        System.out.println("PlaceAop 有返回结果时执行");
    }

    /**
     * Throw 异常时执行
     */
    @AfterThrowing("doAspect()")
    public void deAfterThrowing(JoinPoint joinPoint){
        System.out.println("PlaceAop throw异常时执行");
    }

    /**
     * 环绕通知
     */
    @Around("doAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("PlaceAop 环绕通知");
        return joinPoint.proceed();
    }

}
