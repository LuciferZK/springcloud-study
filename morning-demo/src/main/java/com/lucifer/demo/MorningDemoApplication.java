package com.lucifer.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lucifer
 */
@EnableDiscoveryClient
@MapperScan(basePackages = "com.lucifer.demo.dao*")
@SpringBootApplication
public class MorningDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorningDemoApplication.class, args);
    }

}
