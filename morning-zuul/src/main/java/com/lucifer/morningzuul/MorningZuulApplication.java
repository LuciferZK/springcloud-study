package com.lucifer.morningzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Lucifer
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class MorningZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorningZuulApplication.class, args);
    }

}
