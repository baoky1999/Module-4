package com.customer.customermanagementstoredprocedure.service;

import com.customer.customermanagementstoredprocedure.model.Customer;

public interface ICustomerService {
    boolean saveWithStoredProcedure(Customer customer);
}