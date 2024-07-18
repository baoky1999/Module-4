package com.customer.customermanagementstoredprocedure.service.iml;

import com.customer.customermanagementstoredprocedure.model.Customer;
import com.customer.customermanagementstoredprocedure.repository.ICustomerRepository;
import com.customer.customermanagementstoredprocedure.service.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean saveWithStoredProcedure(Customer customer) {
        return customerRepository.saveWithStoredProcedure(customer);
    }
}
