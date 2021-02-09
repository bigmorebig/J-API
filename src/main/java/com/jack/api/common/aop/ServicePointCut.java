package com.jack.api.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class ServicePointCut {
    @Pointcut("execution(* com.jack.api.service.api.impl.*.*(..))")
    public void pointcut(){
    }

    @Around("pointcut()")
    public Object checkRunTime(ProceedingJoinPoint pjp) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object retValue = pjp.proceed();
        Long endTime = System.currentTimeMillis();
        log.info("service 运行时间为： {}ms", endTime - startTime);
        return retValue;
    }
}
