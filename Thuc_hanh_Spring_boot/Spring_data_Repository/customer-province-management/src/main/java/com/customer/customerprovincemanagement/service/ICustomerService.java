package com.customer.customerprovincemanagement.service;

import com.customer.customerprovincemanagement.model.Customer;
import com.customer.customerprovincemanagement.model.Province;

public interface ICustomerService extends IGenerateService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
