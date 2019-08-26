package com.lucifer.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Lucifer
 */
@EnableConfigServer
@SpringBootApplication
public class MorningConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorningConfigApplication.class, args);
    }

}
