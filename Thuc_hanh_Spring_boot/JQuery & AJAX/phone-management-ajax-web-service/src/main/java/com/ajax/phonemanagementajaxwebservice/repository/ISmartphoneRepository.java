package com.ajax.phonemanagementajaxwebservice.repository;

import com.ajax.phonemanagementajaxwebservice.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {
}
