package com.example.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {


    @Bean
    public String getDeptWithId() {
        return "HR";
    }
}
