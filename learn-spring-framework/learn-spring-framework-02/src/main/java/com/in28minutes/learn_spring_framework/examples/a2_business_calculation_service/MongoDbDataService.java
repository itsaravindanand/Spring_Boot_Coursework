package com.in28minutes.learn_spring_framework.examples.a2_business_calculation_service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//Implementation of the DataService interface for Mongo DB
//@Component
//Since DB communication occurs, use @Repository instead of @Component
@Repository
@Primary
public class MongoDbDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{11, 12, 45, 99, 89};
    }
}
