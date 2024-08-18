package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //Pointcut - When?
    // execution(* PACKAGE.*.*(..))
    @Before("com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")//WHEN
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - Method is called - {} with arguments - {} ",  joinPoint, joinPoint.getArgs());//WHAT
    }

    @After("com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed",  joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.allPackageConfigUsingBean()"
                ,  joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.allPackageConfigUsingBean()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint,
                                                      Object resultValue) {
        logger.info("com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.allPackageConfigUsingBean()"
                ,  joinPoint, resultValue);
    }
}
