package com.begear.spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// import com.begear.spring.model.entity.HelloWorld;
import com.begear.spring.util.HelloWorld;
import com.begear.spring.util.SpringUtil;

public class App {

    public static void main(String[] args) {

        /* ApplicationContext context = new ClassPathXmlApplicationContext(
         * "com/begear/spring/util/SpringBeans.xml"); */
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringUtil.class);

        // HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        // obj.printHello();

        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHelloWorld("Spring3 Java Config");

    }
}
