package com.in28minutes.learn_spring_framework.business_calculation_service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
//Since we have the business logic, we can use @Service annotation
@Service

public class BusinessCalculationService {

    //Object created for DataService
    private DataService dataService;

    //Dependency Injection using Constructor
    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    //definition for the findMax()
    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
