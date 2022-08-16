package com.example.springboot_api_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringBootApiSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiSampleApplication.class, args);
    }

}
