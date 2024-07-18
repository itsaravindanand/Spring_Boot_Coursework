package com.in28minutes.learn_spring_framework.examples.a2_business_calculation_service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BusinessCalculationApp {
    public static void main(String[] args) {
        //No separate configuration and annotation class
        //We also added @Component and @ComponentScan to auto-generate the objects
        try (var context = new AnnotationConfigApplicationContext(BusinessCalculationApp.class)) {
            //Checking the Components
            //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            //Printing the maximum using the findMax() in the BusinessCalculationService
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}