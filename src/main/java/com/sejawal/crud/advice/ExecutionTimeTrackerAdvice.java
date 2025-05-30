package com.sejawal.crud.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice {
    Logger log = org.slf4j.LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);


    @Around("@annotation(com.sejawal.crud.annotation.TrackExecutionTime)")
    public Object trackExecutionTime(ProceedingJoinPoint pjp) throws Throwable{
        long startTime = System.currentTimeMillis();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object object = pjp.proceed();
        long endTime = System.currentTimeMillis();
        log.info(className+"."+methodName+ "() execution time: " + (endTime - startTime) + " ms");
        return object;
    }

}
