package com.makovetskiy.service;

import com.makovetskiy.dao.ProductRepository;
import com.makovetskiy.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<List<Product>> getAll() {
        return Optional.of(productRepository.findAll());
    }

    @Override
    public Optional<Product> create(Product category) {
        return Optional.of(productRepository.save(category));
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> update(Product category) {
        return Optional.of(productRepository.save(category));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
