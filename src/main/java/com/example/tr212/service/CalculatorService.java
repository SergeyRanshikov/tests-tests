package com.example.tr212.service;

import com.example.tr212.Impl.CalculatorServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements CalculatorServiceImpl {
    @Override
    public int plus(int a, int b) {
        return a + b;
        }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
