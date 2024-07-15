package com.customerlist.controller;


import com.customerlist.model.Customer;
import com.customerlist.service.ICustomerSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerSerivce customerSerivce;

    @GetMapping()
    public ModelAndView showList() {
        ModelAndView modelAnhView = new ModelAndView("customer");
        List<Customer> customers = customerSerivce.findAll();
        modelAnhView.addObject("customers", customers);
        return modelAnhView;
    }

    @GetMapping("/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("update");
        Customer customer = customerSerivce.findById(id);
        modelAndView.addObject("customers", customer);
        return modelAndView;
    }

    @PostMapping("/customers")
    public String updateCustomer (@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam String address) {
        Customer customer = new Customer(id, name, email, address);
        customerSerivce.save(customer);
        return "redirect:/customers";
    }
}
