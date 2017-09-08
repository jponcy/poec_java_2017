package com.imie.poec.java.webservice.tp;

import java.util.ArrayList;
import java.util.List;

/**
 * The product DB simulation (DP singleton).
 */
public class ProductDao {
    /** The instance. */
    private static ProductDao instance = null;

    /** The products dictionary. */
    private List<Product> products = new ArrayList<>();

    /** Singleton constructor. */
    private ProductDao() {
        this.initData();
    }

    /** Returns the instance. */
    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDao();
        }

        return instance;
    }

    /** Initialize fake DB content. */
    private void initData() {
        this.products.add(new Product("Papier A4", "A4-paper",
                "Feuille de papier au format A4 compatible toutes imprimante ; grande autonomie", 32f));

        for (int i = 1; i <= 20; ++i) {
            this.products.add(new Product("Fake n°" + i, "fake-" + i,
                    "This fake product is wanderfull and AMAZING!!!!", (i * 42) % 1000));
        }
    }

    /** Finds one by id, null if not found. */
    public Product findById(Long id) {
        for (Product p : this.findAll()) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    /** Finds then returns all products. */
    public List<Product> findAll() {
        return this.products;
    }
}
