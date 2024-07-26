package com.customer.customerprovincemanagement.repository;

import com.customer.customerprovincemanagement.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<Province, Long> {
}
