package com.sunny.spring.boot.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.sunny.spring.boot.collection.web.servlet")
public class SpringBootCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCollectionApplication.class, args);
    }

}
