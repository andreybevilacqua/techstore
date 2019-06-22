package com.abevilacqua.techstore.repository;

import com.abevilacqua.techstore.model.Product;
import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@NoArgsConstructor
public class ProductRepo {

    public List<Product> getProducts() {
        return Product.listAll();
    }
    
    public Optional<Product> getProductById(final long id) {
        return Optional.ofNullable(Product.findById(id));
    }

    @Transactional
    public void addProduct(final Product product) {
        Product.persist(product);
    }

    @Transactional
    public void updateProduct(long id, Product newProduct) {
        getProductById(id).ifPresent(product -> {
            product.name = newProduct.name;
            product.description = newProduct.description;
            product.price = newProduct.price;
            Product.persist(product);
        });
    }
}
