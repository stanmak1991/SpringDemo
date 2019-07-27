package com.makovetskiy.controller;

import com.makovetskiy.model.Category;
import com.makovetskiy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.net.URI;
import java.util.Collections;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView getAll() {
        return getAllCategoriesAndBindToMw();
    }

    @ResponseBody
    @RequestMapping(value = "/api/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllAsJson() {
        return categoryService.getAll().map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.addObject("category", new Category());
        modelAndView.setViewName("add-category");
        return modelAndView;
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Category category, ModelAndView modelAndView) {
        categoryService.create(category);
        return getAllCategoriesAndBindToMw();
    }

    @RequestMapping(value = "/edit-category", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("c_id") Long id, ModelAndView modelAndView) {
        Category result = categoryService.getByIdWithProducts(id).orElseGet(Category::new);
        modelAndView.addObject("category", result);
        modelAndView.setViewName("edit-category");
        return modelAndView;
    }

    @RequestMapping(value = "/edit-category", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute Category category) {
        categoryService.update(category);
        return getAllCategoriesAndBindToMw();
    }

    @RequestMapping(value = "/delete-category", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("c_id") Long id, ModelAndView modelAndView) {
        categoryService.delete(id);

        return getAllCategoriesAndBindToMw();
    }

    @ResponseBody
    @RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return categoryService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @ResponseBody
    @RequestMapping(value = "/api/category", method = RequestMethod.POST)
    public ResponseEntity<Category> add(@RequestBody Category category) {
        return categoryService.create(category)
                .map(c -> ResponseEntity.created(toUri(c.getId())).body(c))
                .orElseGet(ResponseEntity.status(HttpStatus.CONFLICT)::build);
    }

    private ModelAndView getAllCategoriesAndBindToMw() {
        List<Category> list = categoryService.getAll()
                .orElseGet(Collections::emptyList);
        ModelAndView mw = new ModelAndView();
        mw.addObject("categories", list);
        mw.setViewName("categories");
        return mw;
    }

    private URI toUri(Long id) {
        return URI.create(String.format("api/category/%s", id));
    }
}
