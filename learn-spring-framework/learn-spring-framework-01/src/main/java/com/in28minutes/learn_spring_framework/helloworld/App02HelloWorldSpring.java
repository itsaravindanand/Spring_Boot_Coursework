package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //Step 1: Launch a spring context using the configuration class
        //To avoid resource leak warning, the context is used with "try with resources"
        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            //Step 2: Configure the things that we want Spring to manage - using @Configuration Class (Beans) to launch a spring context
            //We created the HelloWorldConfiguration Class with @Configuration
            //with a name() method with @Bean

            //Step 3: Retrieving the bean managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            //Different person details bean methods
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("personByBeanMethodCall"));
            System.out.println(context.getBean("personByParameter"));
            //referred using custom name for the bean, not the actual method name
            System.out.println(context.getBean("address1"));
            //Commented as we are going to use Address.class in next statement
            System.out.println(context.getBean("address3"));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("personByQualifierParameter"));
            //Printing all Beans in Config file using the context with Array Stream, since the context gives a String[]
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
