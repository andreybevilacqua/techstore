package com.abevilacqua.techstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class Product {

    @NotNull
    private final long id;

    @NotNull
    private final String name;

    @NotNull
    private final String description;

    @NotNull
    private final double price;

}
