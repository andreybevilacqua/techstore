package com.abevilacqua.techstore.repository;

import com.abevilacqua.techstore.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepo {

    private List<Product> products;

    public ProductRepo() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

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

    public void deleteProduct(long id) {
        products.stream()
                .filter(product -> product.getId() == id)
                .forEach(product -> products.remove(product));
    }
}
