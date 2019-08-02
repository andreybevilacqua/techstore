package com.abevilacqua.techstore.repository;

import com.abevilacqua.techstore.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductRepo {

    public List<Product> getProducts() {
        return Product.listAll();
    }
    
    public Optional<Product> getProductById(final long id) {
        return Optional.ofNullable(Product.findById(id));
    }

    @Transactional
    public Product addProduct(final Product product) {
        Product.persist(product);
        return product;
    }

    @Transactional
    public void updateProduct(long id, Product newProduct) {
        getProductById(id).ifPresent(product -> {
            product.setName(newProduct.getName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            Product.persist(product);
        });
    }

    @Transactional
    public void deleteProduct(long id) {
        getProductById(id).ifPresent(Product::delete);
    }
}
