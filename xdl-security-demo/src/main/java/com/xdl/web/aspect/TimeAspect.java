package com.xdl.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 自定义切片
 *
 * @author xdl
 * @date 2018-09-29
 */
@Aspect
@Component
@Slf4j
public class TimeAspect {

    @Around("execution(* com.xdl.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint point) throws Throwable {

        long start = System.currentTimeMillis();
        log.info("time aspect start");

        Object[] args = point.getArgs();
        for (Object arg : args) {
            log.info("arg is {}", arg);
        }
        Object object = point.proceed();

        log.info("time aspect 耗时:" + (System.currentTimeMillis() - start));
        log.info("time aspect end");

        return object;
    }

}
