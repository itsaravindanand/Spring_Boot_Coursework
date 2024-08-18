package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect  // Marks this class as an Aspect, which can contain advice (methods that get executed at join points)
@Configuration  // Indicates that this class is a configuration class in Spring
public class PerformanceTrackingAspect {

    // Logger instance for logging messages
    private Logger logger = LoggerFactory.getLogger(getClass());

    // Around advice that wraps the method execution, allowing us to perform actions before and after the method runs
    @Around("com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start a timer before method execution
        long startTimeMillis = System.currentTimeMillis();

        // Execute the target method
        Object returnValue = proceedingJoinPoint.proceed();

        // Stop the timer after method execution
        long stopTimeMillis = System.currentTimeMillis();

        // Calculate the method execution duration
        long executionDuration = stopTimeMillis - startTimeMillis;

        // Log the execution time with the method information
        logger.info("Around Aspect - {} Method executed in {} ms", proceedingJoinPoint, executionDuration);

        // Return the method's return value to maintain normal flow
        return returnValue;
    }

}
