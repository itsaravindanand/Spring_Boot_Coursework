package com.in28minutes.learn_spring_framework.examples.a7_xml_config;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XMLConfigurationContextLauncherApplication {
    public static void main(String[] args) {
        //No separate configuration and annotation class
        //No @Component and @ComponentScan as XML Configuration is used
        //the beans and component scan is found int the xml file
        //Using XML configuration all operation performed using Java Configuration is executed here
        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            context.getBean(GameRunner.class).run();
        }
    }
}
