package com.mydemo.mydemo.Services.serviceImp;

import com.mydemo.mydemo.Services.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public double sum(int a, int b) {
        double res = 0;
        if (a >= 0 || b >= 0) {
            res = a + b;
        }
        return res;

    }

    @Override
    public double divide(int a, int b) {
        int res = 0;
        if (b != 0) {
            res = a / b;
        } else {
            throw new ArithmeticException("no no no");
        }
        return res;
    }

    @Override
    public double subtract(int a, int b) {
        return 0;
    }

    @Override
    public double multiple(int a, int b) {
        return 0;
    }
}
