package com.customerlist.controller;


import com.customerlist.model.Customer;
import com.customerlist.service.ICustomerSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerSerivce customerSerivce;

    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customer> customer = customerSerivce.findAll();
        model.addAttribute("customer", customer);
        return "/customer";
    }
}
