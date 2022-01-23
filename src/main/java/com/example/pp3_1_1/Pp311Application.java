package com.example.pp3_1_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication    //заменяет аннотации @Configuration @EnableAutoConfig @ComponentScan
public class Pp311Application {

    public static void main(String[] args) {
        SpringApplication.run(Pp311Application.class, args);
    }

}
