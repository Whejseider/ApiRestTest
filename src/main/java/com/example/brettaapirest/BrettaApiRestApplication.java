package com.example.brettaapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class BrettaApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrettaApiRestApplication.class, args);
    }

}
