package com.in28minutes.learn_spring_framework.examples.a2_business_calculation_service;

import org.springframework.stereotype.Repository;

//@Component
//Since DB communication occurs, use @Repository instead of @Component
@Repository
public class MySQLDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{22, 57, 88, 45, 69};
    }
}

