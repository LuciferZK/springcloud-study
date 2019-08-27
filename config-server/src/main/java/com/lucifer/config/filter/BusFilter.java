package com.lucifer.config.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: lucifer
 * @date: 2019/8/27
 * @description:
 */
@Component
//@WebFilter(urlPatterns = "/**", filterName = "BusFilter")
public class BusFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String requestURI = httpServletRequest.getRequestURI();
        //过滤掉非/actuator/bus-refresh请求
        if (!requestURI.endsWith("/actuator/bus-refresh")) {
            filterChain.doFilter(req, res);
            return;
        }
        RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, res);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig arg0) {

    }


}

