package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.game")
public class GamingAppLauncherApplication {
    public static void main(String[] args) {
        //No separate configuration and annotation class
        //We also added @Component and @ComponentScan to auto-generate the objects
        try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
            //Accessing Bean Methods using context
            //Accessing GamingConsole interface methods via object created for PacmanGame class in the configuration class
            context.getBean(GamingConsole.class).up();

            //Accessing GameRunner class methods via object created for PacmanGame class (which implements the GamingConsole Interface) in the configuration class
            context.getBean(GameRunner.class).run();
        }
    }
}
