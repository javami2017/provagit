package com.begear.spring.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.begear.spring.model.entity.HelloWorldImpl;

@Configuration
public class SpringUtil {

    @Bean(name="helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }
}
