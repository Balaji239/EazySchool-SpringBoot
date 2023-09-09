package com.eazyschool.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Component
@Aspect
public class LogAspect {

    @Around("execution(* com.eazyschool..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature().toShortString()+ "method execution started");
        Instant start = Instant.now();
        Object obj = joinPoint.proceed();
        Instant finish = Instant.now();
        log.info(joinPoint.getSignature().toShortString()+" method execution ended, took "+ Duration.between(start,finish).toMillis());
        return obj;
    }

    @AfterThrowing(value = "execution(* com.eazyschool..*.*(..))", throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex){
        log.error("Exception happened in "+joinPoint.getSignature().toShortString()+" method due to :"+ex.getMessage());
    }
}
