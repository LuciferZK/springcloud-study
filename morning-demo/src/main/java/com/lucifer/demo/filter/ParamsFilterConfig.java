package com.lucifer.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * @author: lucifer
 * @date: 2019/8/21
 * @description:
 */
@Configuration
public class ParamsFilterConfig  {
    /**
     * 去除参数头尾空格过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean paramsFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new ParamsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("paramsFilter");
        registration.setOrder(Integer.MAX_VALUE-1);
        return registration;
    }
}
