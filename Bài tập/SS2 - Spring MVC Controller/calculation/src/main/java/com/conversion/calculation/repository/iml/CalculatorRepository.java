package com.conversion.calculation.repository.iml;

import com.conversion.calculation.repository.ICalculatorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepository implements ICalculatorRepository {

    @Override
    public double calculate(double firstNumber, double secondNumber, String item) {
        switch (item) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if (secondNumber != 0) {
                    return firstNumber / secondNumber;
                } else {
                    throw new IllegalArgumentException("Cannot divide by zero!");
                }
            default:
                throw new IllegalArgumentException("Invalid operation: " + item);
        }
    }

}
