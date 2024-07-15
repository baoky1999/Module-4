package com.conversion.calculation.service.iml;


import com.conversion.calculation.repository.ICalculatorRepository;
import com.conversion.calculation.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Autowired
    private ICalculatorRepository calculatorRepository;

    @Override
    public double calculate(double firstNumber, double secondNumber, String item) {
        return calculatorRepository.calculate(firstNumber,secondNumber,item);

    }
}
