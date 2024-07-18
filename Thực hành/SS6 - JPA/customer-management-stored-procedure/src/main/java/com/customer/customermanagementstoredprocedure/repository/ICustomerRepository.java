package com.customer.customermanagementstoredprocedure.repository;

import com.customer.customermanagementstoredprocedure.model.Customer;

public interface ICustomerRepository {

    boolean saveWithStoredProcedure(Customer customer);
}
