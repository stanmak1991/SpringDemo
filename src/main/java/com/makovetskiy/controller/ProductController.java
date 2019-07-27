package com.makovetskiy.controller;

import com.makovetskiy.model.Product;
import com.makovetskiy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView getAll() {
        return getAllProductsAndBindToMw();
    }

    private ModelAndView getAllProductsAndBindToMw() {
        List<Product> list = productService.getAll()
                .orElseGet(Collections::emptyList);
        ModelAndView mw = new ModelAndView();
        mw.addObject("products", list);
        mw.setViewName("products");
        return mw;
    }
}
