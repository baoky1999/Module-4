package com.customer.customerprovincemanagement.repository;

import com.customer.customerprovincemanagement.model.Customer;
import com.customer.customerprovincemanagement.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
