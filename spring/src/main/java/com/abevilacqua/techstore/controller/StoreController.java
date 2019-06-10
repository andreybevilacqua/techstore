package com.abevilacqua.techstore.controller;

import com.abevilacqua.techstore.model.Product;
import com.abevilacqua.techstore.repository.ProductRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    private ProductRepo productRepo;

    public StoreController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/")
    public ResponseEntity helloStore() {
        return new ResponseEntity<>("Hey there from TechStore!!!", HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productRepo.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") final String id) {
        return productRepo.getProduct(Long.valueOf(id))
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody final Product product) {
        return new ResponseEntity<>(productRepo.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody final Product product) {
        return new ResponseEntity<>(productRepo.updateProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") final long id) {
        if(productRepo.deleteProduct(id)) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
