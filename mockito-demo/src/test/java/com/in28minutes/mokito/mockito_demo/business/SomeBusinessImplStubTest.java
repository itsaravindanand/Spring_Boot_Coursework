package com.in28minutes.mokito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        DataService dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

    @Test
    void findTheGreatestFromAllData_withOneValue() {
        DataService dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(35, result);
    }

}

//Stub 1
class DataServiceStub1 implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{25, 15, 5};
    }
}

//Stub 2
class DataServiceStub2 implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{35};
    }

}
