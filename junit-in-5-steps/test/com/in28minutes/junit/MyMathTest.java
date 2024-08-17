package com.in28minutes.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyMathTest {

    private MyMath math = new MyMath();

    @Test
    void calculateSum_ThreeMemberArray() {
        //Absence of failure is success
        //Test Conditions or Assert
        assertEquals(6,math.calculateSum(new int[]{1,2,3}));
    }

    @Test
    void calculateSum_ZeroLengthArray() {
        assertEquals(0,math.calculateSum(new int[]{}));
    }
}