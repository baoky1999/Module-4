package com.customerlist.service;

import com.customerlist.model.Customer;

import java.util.List;

public interface ICustomerSerivce {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);
}
