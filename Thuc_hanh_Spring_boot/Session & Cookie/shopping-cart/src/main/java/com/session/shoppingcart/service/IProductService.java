package com.session.shoppingcart.service;

import com.session.shoppingcart.model.Product;

import java.util.Optional;

public interface IProductService {

    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

}
