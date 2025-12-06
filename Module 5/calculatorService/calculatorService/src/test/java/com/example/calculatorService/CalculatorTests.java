package com.example.calculatorService;

import org.junit.jupiter.api.*;

public class CalculatorTests {

    Calculator calculator = new Calculator();

    int arr[];

    @BeforeEach
    void prepareInput() {
        arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println("This runs before Every test");
    }

    @BeforeAll
    static void loadFile() {
        System.out.println("This runs before any Test");
    }

    @AfterAll
    static void destroy() {
        System.out.println("This test runs after all the tests");
    }

    @AfterEach
    void closeFile() {
        System.out.println("This runs after every test");
    }

    @Test
    void whenInputsArePositive_thenReturnPositive() {
        int a = 5;
        int b = 10;
        int expected = 15;
        int actual = calculator.add(a,b);
        System.out.println("Test 1");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void shouldReturnNegative_whenBisGreataerThanA() {
        int a = 5;
        int b = 7;
        int expected = -2;
        int actual = calculator.subtract(a,b);
        System.out.println("Test 2");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void ShouldReturnTrue_whenInputIsEven() {
        int x = 10;
        boolean actual = calculator.isEven(x);
        System.out.println("Test 3");
        Assertions.assertTrue(actual);
    }

    @Test
    void ShouldReturnFalse_whenInputIsOdd() {
        int x = 11;
        boolean actual = calculator.isEven(x);
        System.out.println("Test 4");
        Assertions.assertFalse(actual);
    }

    @Test
    void shouldThrowException_whenDivideByZero(){
        int a = 5;
        int b = 0;
        System.out.println("Test 5");
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(a,b);
        });
    }



}
