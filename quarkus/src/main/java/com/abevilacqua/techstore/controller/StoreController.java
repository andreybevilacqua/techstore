package com.abevilacqua.techstore.controller;

import com.abevilacqua.techstore.model.Product;
import com.abevilacqua.techstore.repository.ProductRepo;
import lombok.NoArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@NoArgsConstructor
public class StoreController {

    private ProductRepo productRepo;

    public StoreController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GET
    public String helloStore() { return "Hey there from TechStore!!!"; }

    @GET
    @Path("/products")
    public List<Product> getProducts() {
        return productRepo.getProducts();
    }

    @GET
    @Path("/product/{id}")
    public Response getProductById(@PathParam("id") long id) {
        if(productRepo.getProductById(id).isPresent()) return Response.ok(productRepo.getProductById(id).get()).build();
        else return Response.status(NOT_FOUND).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response addProduct(Product product) {
        productRepo.addProduct(product);
        return Response.created(URI.create("/product/" + product.id)).build();
    }
}
