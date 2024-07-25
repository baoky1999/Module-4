package com.session.shoppingcart.repository;

import com.session.shoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
