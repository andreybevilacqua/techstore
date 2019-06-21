package com.abevilacqua.techstore.controller;

import com.abevilacqua.techstore.model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class StoreController {

    @GET
    public String helloStore() { return "Hey there from TechStore!!!"; }

    @GET
    @Path("/products")
    public List<Product> getProducts() {
        return Product.listAll();
    }

    @GET
    @Path("/product/{id}")
    public Response getProductById(@PathParam("id") long id) {
        Optional<Product> product = Optional.ofNullable(Product.findById(id));
        if(product.isPresent()) return Response.ok(product.get()).build();
        else return Response.status(NOT_FOUND).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response addProduct(Product product) {
        Product.persist(product);
        return Response.created(URI.create("/product/" + product.id)).build();
    }
}
