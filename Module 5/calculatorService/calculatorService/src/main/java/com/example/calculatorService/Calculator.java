package com.example.calculatorService;

public class Calculator {

    int add(int a, int b) {
        int sum = 0;
        sum += a;
        sum += b;
        return sum;
    }

    int subtract(int a, int b) {
        return a-b;
    }

    int multiply(int a, int b) {
        return a*b;
    }

    int divide(int a, int b) {
        return a/b;
    }

    int addMultipleNums(int ...nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        return sum;
    }

    boolean isEven(int x) {
        return x%2==0;
    }
}
