package com.begear.spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.begear.spring.model.entity.HelloWorld;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/begear/spring/util/SpringBeans.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();
        
    }
}
