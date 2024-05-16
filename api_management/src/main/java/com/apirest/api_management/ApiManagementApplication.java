package com.apirest.api_management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiManagementApplication {

    private final static Logger logger = LoggerFactory.getLogger(ApiManagementApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ApiManagementApplication.class, args);

    }




}
