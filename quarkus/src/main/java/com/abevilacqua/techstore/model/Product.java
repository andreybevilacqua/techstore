package com.abevilacqua.techstore.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Product extends PanacheEntity {

    // PanacheEntity already have a Long ID implemented.
    // So just implement the required attributes.
    private String name;
    private String description;
    private double price;
}
