package com.customer.customermanagementstoredprocedure.controller;

import com.customer.customermanagementstoredprocedure.model.Customer;
import com.customer.customermanagementstoredprocedure.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customersname")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        boolean checkSave = customerService.saveWithStoredProcedure(customer);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        if (checkSave) {
            modelAndView.addObject("message", "New customer created successfully");
        } else {
            modelAndView.addObject("message", "Error exists!");
        }
        return modelAndView;
    }
}
