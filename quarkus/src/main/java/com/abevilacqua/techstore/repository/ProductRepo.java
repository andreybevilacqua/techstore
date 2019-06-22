package com.abevilacqua.techstore.repository;

import com.abevilacqua.techstore.model.Product;
import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.listAll;
import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.persist;

@ApplicationScoped
@NoArgsConstructor
public class ProductRepo {

    public List<Product> getProducts() {
        return listAll();
    }
    
    public Optional<Product> getProductById(final long id) {
        return Optional.ofNullable(Product.findById(id));
    }

    @Transactional
    public void addProduct(Product product) {
        persist(product);
    }
}
