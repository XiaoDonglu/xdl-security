package com.xdl.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 *
 * @author xdl
 * @date 2018-09-28
 */
@Slf4j
//@Component
public class TimeFilter implements Filter {

    @Override
    public void destroy() {
        log.info("time filter destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("time filter start");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        log.info("time filter 耗时:" + (System.currentTimeMillis() - start));
        log.info("time filter finish");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        log.info("time filter init");
    }

}
