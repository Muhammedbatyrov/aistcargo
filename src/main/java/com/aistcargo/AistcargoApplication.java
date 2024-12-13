package com.aistcargo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.aistcargo.model")
public class AistcargoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AistcargoApplication.class, args);
    }

}
