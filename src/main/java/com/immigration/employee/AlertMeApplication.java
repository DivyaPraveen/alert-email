package com.immigration.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AlertMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlertMeApplication.class, args);
    }
}
