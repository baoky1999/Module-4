package com.customer.customermanagementthymeleaf.repository.iml;

import com.customer.customermanagementthymeleaf.model.Product;
import com.customer.customermanagementthymeleaf.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Máy giặt", "Dung tích 15L", 2000, 25));
        products.put(2, new Product(2, "Tủ lạnh", "Dung tích 500L", 3000, 15));
        products.put(3, new Product(3, "Ti vi", "Màn hình 8K", 4000, 30));
        products.put(4, new Product(4, "Điều hòa", "Công nghệ inverter", 2500, 27));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Object findByName(String name) {
        List<Product> products = findAll();
        String search = name.toLowerCase();
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(search)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
