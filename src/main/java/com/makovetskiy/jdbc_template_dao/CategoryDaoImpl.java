package com.makovetskiy.jdbc_template_dao;

import com.makovetskiy.jdbc_template_dao.template.CategoryJdbcTemplate;
import com.makovetskiy.model.Category;

import java.util.List;
import java.util.Optional;

//@Repository
public class CategoryDaoImpl implements CategoryDao {

    //@Autowired
    private CategoryJdbcTemplate template;

    @Override
    public Optional<List<Category>> getAll() {
        return template.getAll();
    }

    @Override
    public Optional<Category> create(Category category) {
        return template.create(category);
    }

    @Override
    public Optional<Category> getById(Long id) {
        return template.getById(id);
    }

    @Override
    public Optional<Category> update(Category category) {
        return template.update(category);
    }

    @Override
    public void delete(Long id) {
        template.delete(id);
    }
}
