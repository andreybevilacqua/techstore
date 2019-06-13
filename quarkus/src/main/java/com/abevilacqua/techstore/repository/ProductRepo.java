package com.abevilacqua.techstore.repository;

import com.abevilacqua.techstore.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepo {

    private List<Product> products;

    public ProductRepo() { products = new ArrayList<>(); }

    public List<Product> getProducts() { return products; }

    public Optional<Product> getProduct(long id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product updateProduct(Product product) {
        deleteProduct(product.getId());
        addProduct(product);
        return product;
    }

    public boolean deleteProduct(long id) {
        if(getProduct(id).isPresent()) {
            products.remove(getProduct(id).get());
            return true;
        } else return false;
    }
}
