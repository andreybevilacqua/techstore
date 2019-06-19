package com.abevilacqua.techstore.controller;

import com.abevilacqua.techstore.model.Product;
import com.abevilacqua.techstore.repository.ProductRepo;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StoreController {

    private ProductRepo productRepo;

    @Inject
    public StoreController(ProductRepo productRepo) { this.productRepo = productRepo; }

    @GET
    public String helloStore() { return "Hey there from TechStore!!!"; }

    @GET
    @Path("/products")
    public List<Product> getProducts() {
        return productRepo.getProducts();
    }
}
