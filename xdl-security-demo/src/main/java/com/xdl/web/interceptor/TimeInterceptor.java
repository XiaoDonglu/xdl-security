package com.xdl.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author xdl
 * @date 2018-09-28
 */
@Component
@Slf4j
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        /*log.info("preHandle");

        log.info(((HandlerMethod) handler).getBean().getClass().getName());
        log.info(((HandlerMethod) handler).getMethod().getName());

        request.setAttribute("startTime", System.currentTimeMillis());*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        /*log.info("postHandle");
        Long start = (Long) request.getAttribute("startTime");
        log.info("time interceptor 耗时:{}", (System.currentTimeMillis() - start));*/
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) {
        /*log.info("afterCompletion");
        Long start = (Long) request.getAttribute("startTime");
        log.info("time interceptor 耗时:{}", (System.currentTimeMillis() - start));
        log.info("ex is {}", ex);*/
    }
}
