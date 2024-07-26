package com.customer.customerprovincemanagement.service.iml;

import com.customer.customerprovincemanagement.model.Province;
import com.customer.customerprovincemanagement.repository.IProvinceRepository;
import com.customer.customerprovincemanagement.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
