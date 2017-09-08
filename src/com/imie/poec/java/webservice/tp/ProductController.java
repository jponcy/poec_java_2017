package com.imie.poec.java.webservice.tp;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    /** Action to get all products. */
    @GetMapping("/product")
    public List<Product> getAll() {
        return ProductDao.getInstance().findAll();
    }
}
