package com.makovetskiy.service;

import com.makovetskiy.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<List<Product>> getAll();

    Optional<Product> create(Product category);

    Optional<Product> getById(Long id);

    Optional<Product> update(Product category);

    void delete(Long id);
}
