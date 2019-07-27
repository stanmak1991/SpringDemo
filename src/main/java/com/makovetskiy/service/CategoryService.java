package com.makovetskiy.service;

import com.makovetskiy.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<List<Category>> getAll();

    Optional<List<Category>> getAllWithProducts();

    Optional<Category> create(Category category);

    Optional<Category> getById(Long id);

    Optional<Category> getByIdWithProducts(Long id);

    Optional<Category> update(Category category);

    void delete(Long id);
}
