package com.abevilacqua.techstore.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends PanacheEntity {

    // PanacheEntity already have a Long ID implemented.
    // So just implement the required attributes.
    public String name;
    public String description;
    public double price;
}
