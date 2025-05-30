package com.sejawal.crud.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    Logger log = org.slf4j.LoggerFactory.getLogger(LoggingAdvice.class);

    //first * is for all packages after 'crud' package, second * is for all classes, third * is for all methods
    @Pointcut(value = "execution(* com.sejawal.crud.*.*.*(..))")
    public void myPointcut() {
    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object array = pjp.getArgs();
        log.info("Method invoked "+ className +" : " + methodName + " arguments: "+ mapper.writeValueAsString(array));

        Object object = pjp.proceed();
        log.info(className +" : " + methodName + ": Response "+ mapper.writeValueAsString(object));
        return object;
    }

}
