package com.eh.eventservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EhEventServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhEventServiceApplication.class, args);
    }

}
