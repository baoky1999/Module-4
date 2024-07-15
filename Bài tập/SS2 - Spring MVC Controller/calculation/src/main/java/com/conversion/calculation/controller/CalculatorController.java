package com.conversion.calculation.controller;

import com.conversion.calculation.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("calculator")
public class CalculatorController {

    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping
    public String showCalculator(Model model) {
        return "/home";
    }

    @PostMapping
    public String result(@RequestParam(value = "first", required = false) double firstNumber,
                         @RequestParam(value = "second", required = false) double secondNumber,
                         @RequestParam("item") String item,
                         Model model) {
        try {
            double result = calculatorService.calculate(firstNumber,secondNumber,item);
            model.addAttribute("result", result);
            return "/home";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect: /calculator";
    }

}
