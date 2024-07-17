package com.in28minutes.learn_spring_framework.game;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        //Let's Launch the GameConsole and GameRunner as Spring Beans
        //Step 1: Creating the Context
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            //Step 2:Creating the configuration class
            //GamingConfiguration class was created

            //Accessing Bean Methods using context
            //Accessing GamingConsole interface methods via object created for PacmanGame class in the configuration class
            context.getBean(GamingConsole.class).up();

            //Accessing GameRunner class methods via object created for PacmanGame class (which implements the GamingConsole Interface) in the configuration class
            context.getBean(GameRunner.class).run();
        }
    }
}
