package com.hxqh.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @author Lin
 */
@SpringBootApplication
@EnableEurekaServer
public class HxqhCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HxqhCenterApplication.class, args);
    }

}

