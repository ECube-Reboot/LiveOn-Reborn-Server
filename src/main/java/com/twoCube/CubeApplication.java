package com.twoCube;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CubeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CubeApplication.class, args);
    }
}
