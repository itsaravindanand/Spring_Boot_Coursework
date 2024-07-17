package com.in28minutes.learn_spring_framework.examples.jakarata_cdi;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
//@Names in Jakarta is similar to @Component in spring framework
@Named
class BusinessService {
    private DataService dataService;

    @Autowired
    //@Inject in Jakarta is similar to @Autowired in spring framework
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }
    public DataService getDataService() {
        return dataService;
    }
}

//@Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class JakartaCdiContextLauncherApplication {
    public static void main(String[] args) {
        //No separate configuration and annotation class
        //We also added @Component and @ComponentScan to auto-generate the objects
        try (var context = new AnnotationConfigApplicationContext(JakartaCdiContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class)
                    .getDataService());
        }
    }
}
