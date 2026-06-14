package com.example.duy_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity // CCho phep phan quyen cac API
public class DuyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuyBackendApplication.class, args);
    }

}
