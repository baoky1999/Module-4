package com.customerlist.repository;

import com.customerlist.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);
}
