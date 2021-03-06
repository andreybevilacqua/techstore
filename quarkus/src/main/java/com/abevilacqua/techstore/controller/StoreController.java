package com.abevilacqua.techstore.controller;

import com.abevilacqua.techstore.model.Product;
import com.abevilacqua.techstore.repository.ProductRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/products")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class StoreController {

    @Inject
    private ProductRepo productRepo;

    @GET
    public List<Product> getProducts() {
        return productRepo.getProducts();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") long id) {
        if(productRepo.getProductById(id).isPresent()) return Response.ok(productRepo.getProductById(id).get()).build();
        else return Response.status(NOT_FOUND).build();
    }

    @POST
    @Produces(APPLICATION_JSON)
    public Response addProduct(Product newProduct) {
        Product p = productRepo.addProduct(newProduct);
        return Response.ok(p).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") final long id, Product product) {
        productRepo.updateProduct(id, product);
        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") final long id) {
        productRepo.deleteProduct(id);
        return Response.noContent().build();
    }
}
