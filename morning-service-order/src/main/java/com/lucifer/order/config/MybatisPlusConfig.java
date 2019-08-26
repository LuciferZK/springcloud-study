package com.lucifer.order.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: lucifer
 * @date: 2019/8/23
 * @description:
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 性能分析拦截器，不建议生产使用   SQL执行效率插件
     * 设置 dev test 环境开启
     */
    @Bean
   // @Profile(value = {"dev", "local"})
    public PerformanceInterceptor performanceInterceptor()
    {
        System.out.println();
        return new PerformanceInterceptor();
    }
}
