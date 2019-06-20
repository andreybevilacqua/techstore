package com.abevilacqua.techstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Entity
public class Product {

    @Id
    private final long id;

    @NotNull
    private final String name;

    @NotNull
    private final String description;

    @NotNull
    private final double price;
}
