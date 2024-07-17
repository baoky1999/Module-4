package com.customer.customermanagementthymeleaf.service;

import com.customer.customermanagementthymeleaf.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    Object findByName(String name);
}
