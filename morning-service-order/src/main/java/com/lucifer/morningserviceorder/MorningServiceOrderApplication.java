package com.lucifer.morningserviceorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.persistence.MappedSuperclass;

/**
 * @author Lucifer
 * @description: 订单服务
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MorningServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorningServiceOrderApplication.class, args);
    }

}
