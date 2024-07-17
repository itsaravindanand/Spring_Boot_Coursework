package com.in28mintues.springboot.learn_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


//Build a rest API
//Create an API for returning the Course with ID, name and author
@RestController
public class CurrencyConfigurationController {
    //Field dependency
    @Autowired
    private CurrencyServiceConfiguration configuration;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration currencyServiceConfiguration (){
        return configuration;
    }
}
