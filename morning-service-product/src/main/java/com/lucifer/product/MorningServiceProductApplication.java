package com.lucifer.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lucifer
 */
@MapperScan(basePackages = "com.lucifer.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class MorningServiceProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorningServiceProductApplication.class, args);
    }

}
