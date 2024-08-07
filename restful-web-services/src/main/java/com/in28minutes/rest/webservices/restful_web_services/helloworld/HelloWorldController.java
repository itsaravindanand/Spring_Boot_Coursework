package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//Expose REST API
@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
//URL: /helloWorld
    //Return Hello World

    //Direct String returned
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    //HelloWorld Bean returned
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    //path variable/parameters
    //Ex: /users/{user_id}/todos/{todo_id} => /users/1/todos/101, the url for user 1 and todos 101
    //the id is the variable here
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        //Appending Strings
        //return new HelloWorldBean("Hello World, "+ name);
        //Using String formatter
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    //Hello World I18N
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
        //return "Hello World V2";
    }
}
