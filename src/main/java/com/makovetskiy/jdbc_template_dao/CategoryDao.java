package com.makovetskiy.jdbc_template_dao;

import com.makovetskiy.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {
    Optional<List<Category>> getAll();

    Optional<Category> create(Category category);

    Optional<Category> getById(Long id);

    Optional<Category> update(Category category);

    void delete(Long id);
}
