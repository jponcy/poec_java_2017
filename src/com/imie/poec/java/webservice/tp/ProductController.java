package com.imie.poec.java.webservice.tp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Uses JsonMessage to send error message and another, but it is not the best solutions. Another could be:
 * - use exception (serialized into json)
 * - return response instead of object to be able to manage it
 * - use global mechanics
 * - ...
 * The worst about current solution (JsonMessage) is we always reply with 200 status code.
 * Other example: https://dzone.com/articles/exception-handling-spring-rest
 */
@RestController
public class ProductController {

    /** Action to get all products. */
    @GetMapping("/product")
    public List<Product> getAll() {
        return ProductDao.getInstance().findAll();
    }

    @GetMapping("/product_ugly/{id}")
    public Entity getOneUgly(@PathVariable long id) {
        Entity entity = ProductDao.getInstance().findById(id);

        if (entity == null) {
            entity = new JsonMessage("Entity not found.");
        }

        return entity;
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getOne(@PathVariable long id) {
        Product entity = ProductDao.getInstance().findById(id);

        if (entity == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Product>(entity, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> create(@RequestParam String name,
            @RequestParam String reference,
            @RequestParam(required = false) String description,
            @RequestParam float price) {
        Product prod = new Product();

        prod.setName(name);
        prod.setReference(reference);
        prod.setDescription(description);
        prod.setPrice(price);

        if (ProductDao.getInstance().persist(prod)) {
            return new ResponseEntity<Product>(prod, HttpStatus.OK);
        } else {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product_ugly/{id}")
    public JsonMessage updateUgly(@PathVariable long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String reference,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Float price) {
        Product prod = ProductDao.getInstance().findById(id);
        short fieldEdited = 0;

        if (prod == null) {
            return new JsonMessage("Product not found");
        }

        if (name != null) {
            prod.setName(name);
            ++ fieldEdited;
        }

        if (reference != null) {
            prod.setReference(reference);
            ++ fieldEdited;
        }

        if (description != null) {
            prod.setDescription(description);
            ++ fieldEdited;
        }

        if (price != null) {
            prod.setPrice(price);
            ++ fieldEdited;
        }

        if (fieldEdited == 0) {
            return new JsonMessage("No editted field");
        }

        return new JsonMessage("Product edited");
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<?> update(@PathVariable long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String reference,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Float price) {
        Product prod = ProductDao.getInstance().findById(id);
        short fieldEdited = 0;

        if (prod == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        if (name != null) {
            prod.setName(name);
            ++ fieldEdited;
        }

        if (reference != null) {
            prod.setReference(reference);
            ++ fieldEdited;
        }

        if (description != null) {
            prod.setDescription(description);
            ++ fieldEdited;
        }

        if (price != null) {
            prod.setPrice(price);
            ++ fieldEdited;
        }

        if (fieldEdited == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No editted field");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    /** Deletes the entity with given id. */
    @DeleteMapping("/product_ugly/{id}")
    public JsonMessage deleteUgly(@PathVariable long id) {
        String message = (ProductDao.getInstance().delete(id))
                ? "Delete successfull" : "Entity not found";

        return new JsonMessage(message);
    }

    /** Deletes the entity with given id. */
    @SuppressWarnings("rawtypes")
    @DeleteMapping("/product_ugly/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        HttpStatus status = (ProductDao.getInstance().delete(id))
                ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity(status);
    }
}
