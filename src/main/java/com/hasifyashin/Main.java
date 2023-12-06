package com.hasifyashin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.hasifyashin.controllers",
    "com.hasifyashin.repositories",
    "com.hasifyashin.config"
})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}