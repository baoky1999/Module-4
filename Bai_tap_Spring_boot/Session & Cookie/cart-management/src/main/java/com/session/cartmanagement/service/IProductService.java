package com.session.cartmanagement.service;

import com.session.cartmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
}
