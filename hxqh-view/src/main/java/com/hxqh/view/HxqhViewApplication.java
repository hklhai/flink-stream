package com.hxqh.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Lin
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class HxqhViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(HxqhViewApplication.class, args);
    }

}

