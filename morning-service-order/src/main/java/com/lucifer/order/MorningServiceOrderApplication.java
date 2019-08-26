package com.lucifer.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lucifer
 * @description: 订单服务
 */
@MapperScan(basePackages = "com.lucifer.order.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class MorningServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorningServiceOrderApplication.class, args);
    }

}
