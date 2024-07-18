package com.in28minutes.learn_spring_framework.examples.a3_lazy_initialization;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}

@Component
//Avoid Eager Initialization
//Without this @Lazy annotation, the ClassB constructor is constructed with Class A auto-wired
@Lazy
class ClassB{
    private ClassA classA;
    public ClassB(ClassA classA){
        //Other initialization logics
        System.out.println("Some Initialization logic!");
        this.classA = classA;
    }
    public void doSomething(){
        System.out.println("Some logic is executed!");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        //No separate configuration and annotation class
        //We also added @Component and @ComponentScan to auto-generate the objects
        try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("Initialization of context is completed");
            //context.getBean(ClassB.class).doSomething();
        }
    }
}
