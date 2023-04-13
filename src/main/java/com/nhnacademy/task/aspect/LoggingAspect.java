package com.nhnacademy.task.aspect;

import com.nhnacademy.task.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {

    private final static Logger log = LoggerFactory.getLogger(LoggingAspect.class);
    public Object targetDooraySender(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        try {
            Object retVal = pjp.proceed();
            return retVal;

        } catch (Throwable e) {
            e.printStackTrace();
            throw e;

        }finally {
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime -startTime;
            log.info("[{}].[{}] {}ms",className,methodName,elapsedTime);


        }
    }
}
