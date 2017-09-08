package com.imie.poec.java.webservice.tp;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    /** Action to get all products. */
    @GetMapping("/product")
    public List<Product> getAll() {
        return ProductDao.getInstance().findAll();
    }

    @GetMapping("/product/{id}")
    public Product getOne(@PathVariable long id) {
        return ProductDao.getInstance().findById(id);
    }
}
