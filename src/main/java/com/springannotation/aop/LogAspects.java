package com.springannotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 日志切面类
 *  用来配置切面
 * @author lijichen
 * @date 2020/11/28 - 18:15
 */
@Aspect//指定这个类是切面类
public class LogAspects {

    @Pointcut("execution(public int com.springannotation.aop.MathCalculator.*(..))")
    public void pointCut(){}//公用的切入点表达式

    @Before("pointCut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() +
                "方法运行之前,注解为@Before。。参数列表为{"+ Arrays.toString(joinPoint.getArgs()) +"}");
    }
    @After("pointCut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() +
                "方法运行之后,注解为@After。。参数列表为{"+ Arrays.toString(joinPoint.getArgs()) +"}");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() +
                "方法返回结果后,注解为@AfterReturning。。参数列表为{"+ Arrays.toString(joinPoint.getArgs()) +"}，返回值为：" +
                result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() +
                "方法出现异常后,注解为@AfterThrowing。。参数列表为{"+ Arrays.toString(joinPoint.getArgs()) +"}，异常信息为：" +
                exception);
    }


}
