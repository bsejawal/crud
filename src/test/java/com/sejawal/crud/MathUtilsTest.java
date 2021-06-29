package com.sejawal.crud;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("When running MathUtils")
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All should be static method");
    }

    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }

    @Nested
    @DisplayName("add method")
    class AddTest{
        @Test
        @DisplayName("when adding two positive numbers")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1,1), "should return the right sum");
        }
        @Test
        @DisplayName("when adding two negative numbers")
        void testAddNegative() {
            int expected = -2;
            int actual = mathUtils.add(-1,-1);
            assertEquals(expected, actual, ()-> "should return the sum "+ expected +" but returned "+ actual);
        }
    }

    @Test
    @DisplayName("Multiply method")
    void testMultiply(){
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2,2)),
                () -> assertEquals(0, mathUtils.multiply(2,0)),
                () -> assertEquals(-2, mathUtils.multiply(2,-1))
        );
    }




    @Test
    @DisplayName("Divide method")
    void testDivide(){
        boolean isServerUp = true;
        assumeTrue(isServerUp);// just to implement assumeTrue()
        assertThrows(ArithmeticException.class, ()->mathUtils.divide(1,0), "Divide by zero should throw ArithmeticException");


    }
    @RepeatedTest(3)
    void testComputeCircleArea(RepetitionInfo info){
        info.getCurrentRepetition();
        info.getTotalRepetitions();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");

    }

    @Test
    @DisplayName("Test add method")
    @Disabled
    void testAddMethod(){
        fail("test fail");
    }

    @AfterEach
    @Disabled
    void afterEach(){
        System.out.println("after each");
    }
    @AfterAll
    @Disabled
    static void afterAll(){
        System.out.println("AfterAll");
    }

}