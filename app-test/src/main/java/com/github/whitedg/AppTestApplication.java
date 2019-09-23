package com.github.whitedg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(nameGenerator = SpringBeanNameGenerator.class)
public class AppTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppTestApplication.class, args);
    }

}
