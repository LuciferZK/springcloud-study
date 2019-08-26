package com.lucifer.morningserviceproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lucifer
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MorningServiceProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorningServiceProductApplication.class, args);
    }

}
